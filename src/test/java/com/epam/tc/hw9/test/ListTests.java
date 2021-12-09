package com.epam.tc.hw9.test;

import static com.epam.tc.hw9.steps.ListSteps.NEW_ACCESS;
import static com.epam.tc.hw9.steps.ListSteps.NEW_LIST_NAME;
import static environment.Constants.NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.equalTo;

import beans.Board;
import beans.List;
import com.epam.tc.hw9.steps.BoardSteps;
import com.epam.tc.hw9.steps.ListSteps;
import com.epam.tc.hw9.util.DataProviders;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ListTests {

    BoardSteps boardSteps;
    ListSteps listSteps;
    String boardID;
    String listID;

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

    @Test(priority = 1, dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void createNewListTest(Board board, List list) {
        listSteps = new ListSteps();
        boardID = boardSteps.newBoardCreation(board);
        listID = listSteps.newListCreation(boardID, list);
        List createdList = listSteps.getList(listID);
        assertThat(createdList.getName(), equalTo(list.getName()));
    }

    @Test(priority = 2, dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void changeListNameTest(Board board, List list) {
        listSteps = new ListSteps();
        boardID = boardSteps.newBoardCreation(board);
        listID = listSteps.newListCreation(boardID, list);
        List updatedList = listSteps.changeListName(listID);
        assertThat(updatedList.getName(), equalTo(NEW_LIST_NAME));
    }

    @Test(priority = 3, dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void changeListStatusTest(Board board, List list) {
        listSteps = new ListSteps();
        boardID = boardSteps.newBoardCreation(board);
        listID = listSteps.newListCreation(boardID, list);
        List updatedList = listSteps.changeListStatusToClosed(listID);
        assertThat(String.valueOf(updatedList.getClosed()), equalTo(NEW_ACCESS));
    }

    @Test(priority = 4, dataProvider = "listData", dataProviderClass = DataProviders.class)
    public void changeClosedListNameTest(Board board, List list) {
        listSteps = new ListSteps();
        boardID = boardSteps.newBoardCreation(board);
        listID = listSteps.newListCreation(boardID, list);
        List updatedList = listSteps.changeListStatusToClosed(listID);
        listSteps.changeListName(listID);
        Response response = listSteps.getResponse(updatedList);
        assertThat(response.getBody().asString(), containsStringIgnoringCase(NAME));
    }
}
