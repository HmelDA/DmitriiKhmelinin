package com.epam.tc.hw7.test;

import static com.epam.tc.hw7.site.JdiTestingSite.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.selectPage;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.areResultLogsTextEqualsToExpected;

import com.epam.tc.hw7.entities.MetalsAndColors;
import com.epam.tc.hw7.service.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.site.pages.forms.MetalsAndColorsForm;
import org.testng.annotations.Test;

public class MetalsAndColorsPageTest extends TestInit {

    private static final String METALS_AND_COLORS = "Metals & Colors";

    @Test(dataProvider = "MetalsAndColors", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void mainContentTest(MetalsAndColors metalsAndColorsFormData) {
        selectPage(METALS_AND_COLORS);
        metalsAndColorsPage.metalsAndColorsForm.fill(metalsAndColorsFormData);
        MetalsAndColorsForm.clickSubmitButton();
        areResultLogsTextEqualsToExpected(metalsAndColorsFormData);
    }
}
