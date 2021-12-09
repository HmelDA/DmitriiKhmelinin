package com.epam.tc.hw9.steps;

import static environment.Constants.ID_BOARD;
import static environment.Constants.IS_CLOSED;
import static environment.Constants.NAME;
import static service.CommonService.commonApiBuilder;
import static service.CommonService.extractListFromJson;
import static service.CommonService.sendRequestAndGetResponse;

import beans.List;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import service.CommonService;
import service.Specifications;
import util.PropertyReader;
import util.RandomStringGenerator;


public class ListSteps {

    public static final String LIST_URI = "lists/";
    public static final URI LIST_URL = URI.create(PropertyReader.baseUrl() + LIST_URI);
    public static String NEW_LIST_NAME = RandomStringGenerator.generateString();
    public static String NEW_ACCESS = "true";

    @Step("Create new list")
    public String newListCreation(String boardID, List list) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.POST)
                .setQueryParameter(NAME, list.getName())
                .setQueryParameter(ID_BOARD, boardID);
        return extractListFromJson(sendRequestAndGetResponse(api,
                Specifications.responseSpecificationOK200(), LIST_URL)).getId();
    }

    @Step("Get list")
    public List getList(String listID) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setId(listID);
        return extractListFromJson(
                sendRequestAndGetResponse(api, Specifications.responseSpecificationOK200(), LIST_URL));
    }

    @Step("Get response")
    public Response getResponse(List list) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setId(list.getId());
        return sendRequestAndGetResponse(api, Specifications.responseSpecificationOK200(), LIST_URL);
    }

    @Step("Change list name")
    public List changeListName(String listID) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(listID);
        api.setQueryParameter(NAME, NEW_LIST_NAME);
        return extractListFromJson(sendRequestAndGetResponse(
                api, Specifications.responseSpecificationOK200(), LIST_URL));
    }

    @Step("Change list status")
    public List changeListStatusToClosed(String listID) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(listID);
        api.setQueryParameter(IS_CLOSED, NEW_ACCESS);
        return extractListFromJson(sendRequestAndGetResponse(
                api, Specifications.responseSpecificationOK200(), LIST_URL));
    }
}
