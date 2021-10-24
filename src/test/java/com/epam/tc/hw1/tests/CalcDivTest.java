package com.epam.tc.hw1.tests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.epam.tc.hw1.CalcBaseTest;
import com.epam.tc.hw1.dataprovider.DataProviderForCalcTests;
import org.testng.annotations.Test;

public class CalcDivTest extends CalcBaseTest {

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "divDoubleData")
    public void divDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "divZeroDoubleData")
    public void divZeroDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }


    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "divLongData")
    public void divLongTest(long a, long b, long expected) {
        long actual = calculator.div(a, b);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProviderClass = DataProviderForCalcTests.class, dataProvider = "divZeroLongData")
    public void divZeroLongTest(long a, long b) {
        assertThatThrownBy(
                () -> calculator.div(a, b)
        ).isInstanceOf(NumberFormatException.class);
    }
}
