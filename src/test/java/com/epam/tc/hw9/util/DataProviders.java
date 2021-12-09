package com.epam.tc.hw9.util;

import beans.Board;
import beans.List;
import org.testng.annotations.DataProvider;
import util.RandomStringGenerator;


public class DataProviders {

    @DataProvider
    public static Object[][] boardData() {

        Board board1 = new Board();
        Board board2 = new Board();
        Board board3 = new Board();

        board1.setName(RandomStringGenerator.generateString());
        board2.setName(RandomStringGenerator.generateString());
        board3.setName(RandomStringGenerator.generateString());

        return new Object[][]{
                {board1},
                {board2},
                {board3}
        };
    }

    @DataProvider
    public static Object[][] listData() {
        Board board = new Board();
        board.setName(RandomStringGenerator.generateString());
        List list = new List();
        list.setName(RandomStringGenerator.generateString());
        return new Object[][]{
                {board, list}
        };
    }
}
