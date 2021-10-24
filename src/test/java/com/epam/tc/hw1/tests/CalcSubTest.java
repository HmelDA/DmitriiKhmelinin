package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalcBaseTest;
import com.epam.tc.hw1.dataprovider.DataProviderForCalcTests;
import org.testng.annotations.Test;


public class CalcSubTest extends CalcBaseTest {

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "subLongDoubleData")
    public void subDoubleTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "subLongDoubleData")
    public void subLongTest(long a, long b, long expected) {
        long actual = calculator.sub(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}

