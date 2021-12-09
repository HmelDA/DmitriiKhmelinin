package com.epam.tc.hw9.steps;

import beans.Board;
import com.epam.tc.hw9.util.PropertyReader;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import service.CommonService;
import service.Specifications;
import util.RandomStringGenerator;

import java.net.URI;

import static environment.Constants.*;
import static service.CommonService.*;


public class BoardSteps {

    public static final String BOARD_URI = "boards/";
    static String wv = PropertyReader.baseUrl() + BOARD_URI;
    //static String wv = "https://api.trello.com/1/boards/";
    public static final URI BOARD_URL = URI.create(wv);
    public static String NEW_BOARD_NAME = RandomStringGenerator.generateString();
    public static String NEW_DESCRIPTION = RandomStringGenerator.generateString();
    public static String NEW_ACCESS = "true";

    @Step("Create new board")
    public String newBoardCreation(Board board) {
        CommonService.CommonApiBuilder api = commonApiBuilder()
                .setMethod(Method.POST)
                .setQueryParameter(NAME, board.getName());

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

        CommonService.CommonApiBuilder builder = commonApiBuilder()
                .setMethod(Method.GET)
                .setId(boardID);

        return sendRequestAndGetResponse(
                builder, Specifications.responseSpecificationNotFound404(), BOARD_URL);
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
