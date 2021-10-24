package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw1.CalcBaseTest;
import com.epam.tc.hw1.dataprovider.DataProviderForCalcTests;
import org.testng.annotations.Test;

public class CalcSumTest extends CalcBaseTest {

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "sumLongDoubleData")
    public void sumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "sumLongDoubleData")
    public void sumLongTest(long a, long b, long expected) {
        long actual = calculator.sum(a, b);
        assertThat(actual).isEqualTo(expected);
    }
}
