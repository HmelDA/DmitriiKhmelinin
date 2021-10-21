package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalcSumTest extends CalcBaseTest {

    @DataProvider
    public Object[][] longdoubleData() {
        return new Object[][]{
                {4, -8, -4},
                {15, 16, 31},
                {-23, 42, 19}
        };
    }

    @Test(dataProvider = "longdoubleData")
    public void sumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "longdoubleData")
    public void sumLongTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
