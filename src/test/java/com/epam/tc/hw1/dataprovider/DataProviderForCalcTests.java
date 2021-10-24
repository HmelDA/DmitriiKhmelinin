package com.epam.tc.hw1.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderForCalcTests {

    @DataProvider
    public static Object[][] sumLongDoubleData() {
        return new Object[][]{
                {4, -8, -4},
                {15, 16, 31},
                {-23, 42, 19}
        };
    }

    @DataProvider
    public static Object[][] subLongDoubleData() {
        return new Object[][]{
                {4, -8, 12},
                {15, 16, -1},
                {-23, 42, -65}
        };
    }

    @DataProvider
    public static Object[][] multLongDoubleData() {
        return new Object[][]{
                {4, -8, -32},
                {15, 16, 240},
                {-23, 42, -966}
        };
    }

    @DataProvider
    public static Object[][] divDoubleData() {
        return new Object[][]{
                {4, 8, 0.5},
                {15, 16, 0.9375},
                {23, 42, 0.5476190476190477}
        };
    }

    @DataProvider
    public static Object[][] divZeroDoubleData() {
        return new Object[][]{
                {4, 0.0, Double.POSITIVE_INFINITY},
                {-8, 0.0, Double.NEGATIVE_INFINITY},
                {15, -0.0, Double.NEGATIVE_INFINITY},
                {-16, -0.0, Double.POSITIVE_INFINITY}
        };
    }

    @DataProvider
    public static Object[][] divLongData() {
        return new Object[][]{
                {8, 4, 2},
                {16, 8, 2},
                {140, 7, 20}
        };
    }

    @DataProvider
    public static Object[][] divZeroLongData() {
        return new Object[][]{
                {4, 0L},
                {-8, 0L},
                {15, -0L},
                {-16, -0L}
        };
    }
}
