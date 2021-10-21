package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalcMultTest extends CalcBaseTest {
    @DataProvider
    public Object[][] longdoubleData() {
        return new Object[][]{
                {4, -8, -32},
                {15, 16, 240},
                {-23, 42, -966}
        };
    }

    @Test(dataProvider = "longdoubleData")
    public void multDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "longdoubleData")
    public void multLongTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
