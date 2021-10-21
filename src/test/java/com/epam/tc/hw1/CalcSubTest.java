package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CalcSubTest extends CalcBaseTest {
    @DataProvider
    public Object[][] longdoubleData() {
        return new Object[][]{
                {4, -8, 12},
                {15, 16, -1},
                {-23, 42, -65}
        };
    }

    @Test(dataProvider = "longdoubleData")
    public void subDoubleTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "longdoubleData")
    public void subLongTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

