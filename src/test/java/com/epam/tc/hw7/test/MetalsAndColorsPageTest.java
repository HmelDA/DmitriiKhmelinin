package com.epam.tc.hw7.test;

import static com.epam.tc.hw7.site.JdiTestingSite.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.selectPage;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.areResultLogsTextEqualsToExpected;

import com.epam.tc.hw7.entities.MainContent;
import com.epam.tc.hw7.service.MetalsAndColorsDataProvider;
import com.epam.tc.hw7.site.pages.MetalsAndColorsPage;
import org.testng.annotations.Test;

public class MetalsAndColorsPageTest extends BaseTest {

    private static final String METALS_AND_COLORS = "Metals & Colors";

    @Test(dataProvider = "MetalsAndColorsMainContent", dataProviderClass = MetalsAndColorsDataProvider.class)
    public void mainContentTest(MainContent mainContentFromJson) {
        selectPage(METALS_AND_COLORS);
        metalsAndColorsPage.mainContentForm.fill(mainContentFromJson);
        MetalsAndColorsPage.clickSubmitButton();
        areResultLogsTextEqualsToExpected(mainContentFromJson);
    }
}
