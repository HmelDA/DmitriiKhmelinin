package com.epam.tc.hw9.steps;

import static environment.Constants.DEFAULT_LISTS;
import static environment.Constants.DESCRIPTION;
import static environment.Constants.IS_CLOSED;
import static environment.Constants.NAME;
import static service.CommonService.commonApiBuilder;
import static service.CommonService.extractBoardFromJson;
import static service.CommonService.sendRequestAndGetResponse;

import beans.Board;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import java.net.URI;
import service.CommonService;
import service.Specifications;
import util.PropertyReader;
import util.RandomStringGenerator;


public class BoardSteps {

    public static final String BOARD_URI = "boards/";
    public static final URI BOARD_URL = URI.create(PropertyReader.baseUrl() + BOARD_URI);
    public static String NEW_BOARD_NAME = RandomStringGenerator.generateString();
    public static String NEW_DESCRIPTION = RandomStringGenerator.generateString();
    public static String NEW_ACCESS = "true";

    @Step("Create new board")
    public String newBoardCreation(Board board) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.POST)
                .setQueryParameter(NAME, board.getName())
                .setQueryParameter(DEFAULT_LISTS, "false");

        return extractBoardFromJson(sendRequestAndGetResponse(
                api, Specifications.responseSpecificationOK200(), BOARD_URL)).getId();
    }

    @Step("Get board")
    public Board getBoard(String boardID) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setId(boardID);
        return extractBoardFromJson(sendRequestAndGetResponse(
                api, Specifications.responseSpecificationOK200(), BOARD_URL));
    }

    @Step("Delete board")
    public void deleteBoard(String boardID) {

        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.DELETE)
                .setId(boardID);
        sendRequestAndGetResponse(api, Specifications.responseSpecificationOK200(), BOARD_URL);
    }

    @Step("Get deleted board")
    public Response getDeletedBoard(String boardID) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setId(boardID);

        return sendRequestAndGetResponse(
                api, Specifications.responseSpecificationNotFound404(), BOARD_URL);
    }

    @Step("Change deleted board name")
    public Response changeDeletedBoardName(String boardID) {

        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(boardID);
        api.setQueryParameter(NAME, NEW_BOARD_NAME);
        return sendRequestAndGetResponse(
                api, Specifications.responseSpecificationNotFound404(), BOARD_URL);
    }

    @Step("Change board name")
    public Board changeBoardName(String boardID) {

        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(boardID);
        api.setQueryParameter(NAME, NEW_BOARD_NAME);
        return extractBoardFromJson(sendRequestAndGetResponse(
                api, Specifications.responseSpecificationOK200(), BOARD_URL));
    }

    @Step("Change board description")
    public Board changeBoardDescription(String boardID) {

        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(boardID);
        api.setQueryParameter(DESCRIPTION, NEW_DESCRIPTION);
        return extractBoardFromJson(sendRequestAndGetResponse(
                api, Specifications.responseSpecificationOK200(), BOARD_URL));
    }

    @Step("Change board status")
    public Board changeBoardStatus(String boardID) {

        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.PUT)
                .setId(boardID);
        api.setQueryParameter(IS_CLOSED, NEW_ACCESS);
        return extractBoardFromJson(sendRequestAndGetResponse(
                api, Specifications.responseSpecificationOK200(), BOARD_URL));
    }
}
