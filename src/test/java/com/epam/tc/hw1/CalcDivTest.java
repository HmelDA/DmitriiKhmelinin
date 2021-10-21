package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalcDivTest extends CalcBaseTest {
    @DataProvider
    public Object[][] doubleData() {
        return new Object[][]{
                {4, 8, 0.5},
                {15, 16, 0.9375},
                {23, 42, 0.5476190476190477}
        };
    }

    @Test(dataProvider = "doubleData")
    public void divDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider
    public Object[][] divZeroDoubleData() {
        return new Object[][]{
                {4, 0.0, Double.POSITIVE_INFINITY},
                {-8, 0.0, Double.NEGATIVE_INFINITY},
                {15, -0.0, Double.NEGATIVE_INFINITY},
                {-16, -0.0, Double.POSITIVE_INFINITY}
        };
    }

    @Test(dataProvider = "divZeroDoubleData")
    public void divZeroDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider
    public Object[][] longData() {
        return new Object[][]{
                {8, 4, 2},
                {16, 8, 2},
                {140, 7, 20}
        };
    }

    @Test(dataProvider = "longData")
    public void divLongTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @DataProvider
    public Object[][] divZeroLongData() {
        return new Object[][]{
                {4, 0L},
                {-8, 0L},
                {15, -0L},
                {-16, -0L}
        };
    }

    @Test(dataProvider = "divZeroLongData")
    public void divZeroLongTest(long a, long b) {
        assertThatThrownBy(
                () -> calculator.div(a, b)
        ).isInstanceOf(NumberFormatException.class);
    }
}
