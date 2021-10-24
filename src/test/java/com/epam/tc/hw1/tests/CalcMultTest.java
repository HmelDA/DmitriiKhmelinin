package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalcBaseTest;
import com.epam.tc.hw1.dataprovider.DataProviderForCalcTests;
import org.testng.annotations.Test;


public class CalcMultTest extends CalcBaseTest {

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "multLongDoubleData")
    public void multDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "multLongDoubleData")
    public void multLongTest(long a, long b, long expected) {
        long actual = calculator.mult(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
