package com.epam.tc.hw9.test;

import static environment.Constants.NOT_FOUND_MESSAGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

import beans.Board;
import com.epam.tc.hw9.util.DataProviders;
import com.epam.tc.hw9.steps.BoardSteps;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardTests {

    public BoardSteps boardSteps;
    public String boardID;

    @BeforeMethod
    public void beforeMethod() {
        boardSteps = new BoardSteps();
    }

    @AfterMethod
    public void afterMethod() {
        if (boardID != null) {
            boardSteps.deleteBoard(boardID);
        }
    }

    @Test(priority = 1, dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void createNewBoardTest(Board board) {
        boardID = boardSteps.newBoardCreation(board);
        Board createdBoard = boardSteps.getBoard(boardID);
        assertThat(createdBoard.getName(), equalTo(board.getName()));
    }

    @Test(priority = 2, dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void deleteBoardTest(Board board) {
        boardID = boardSteps.newBoardCreation(board);
        boardSteps.deleteBoard(boardID);
        Response response = boardSteps.getDeletedBoard(boardID);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
        assertThat(response.getStatusLine(), containsStringIgnoringCase(NOT_FOUND_MESSAGE));
        boardID = null;
    }

    @Test(priority = 2, dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void changeBoardNameTest(Board board) {
        boardID = boardSteps.newBoardCreation(board);
        Board boardToUpdate = boardSteps.changeBoardName(boardID);
        assertThat(boardToUpdate.getName(), equalTo(BoardSteps.NEW_BOARD_NAME));
    }

    @Test(priority = 2, dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void changeBoardDescriptionTest(Board board) {
        boardID = boardSteps.newBoardCreation(board);
        Board boardToUpdate = boardSteps.changeBoardDescription(boardID);
        assertThat(boardToUpdate.getDesc(), equalTo(BoardSteps.NEW_DESCRIPTION));
    }

    @Test(priority = 2, dataProvider = "boardData", dataProviderClass = DataProviders.class)
    public void changeBoardStatusTest(Board board) {
        boardID = boardSteps.newBoardCreation(board);
        Board boardToUpdate = boardSteps.changeBoardStatus(boardID);
        assertThat(String.valueOf(boardToUpdate.getClosed()), equalTo(BoardSteps.NEW_ACCESS));
    }

//    1)Create board
//        - Board random name
//    2)Update board
//        - Change board name
//    3)Delete board
//    4)Get deleted board
//        - Change board name
//-------------------------------------
//    methods:
//    - create board with random name
//    - change board name (random)

}
