package com.epam.tc.hw7.site.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.MainContent;
import com.epam.tc.hw7.site.pages.forms.MainContentForm;
import java.util.List;
import java.util.stream.Collectors;


@Url("metals-colors.html")
@Title("Metals & Colors")
public class MetalsAndColorsPage extends WebPage {

    @Css(".form")
    public MainContentForm mainContentForm;

    @UI("#submit-button")
    public static Button submitButton;

    @Css(".results li")
    private static List<UIElement> resultLogs;

    public static List<String> getResultLogsText() {
        return resultLogs.stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }

    public static void areResultLogsTextEqualsToExpected(MainContent mainContent) {
        assertThat(getResultLogsText()).isEqualTo(mainContent.testExpectedResults());
    }

    public static void clickSubmitButton() {
        submitButton.click();
    }
}
