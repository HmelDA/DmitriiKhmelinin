package com.epam.tc.hw7.site.pages.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.tc.hw7.entities.MetalsAndColors;

public class MetalsAndColorsForm extends Form<MetalsAndColors> {

    @UI(".radio")
    public static JList<Label> summary;

    @UI("p.checkbox")
    public static JList<Label> elements;

    @JDropdown(root = "#colors",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "#metals",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @JDropdown(root = "#vegetables",
            value = "#salad-dropdown > button",
            list = "li",
            expand = ".caret")
    public static Dropdown vegetables;

    @UI("#submit-button")
    public static Button submitButton;

    public static void clickSubmitButton() {
        submitButton.click();
    }

    @Override
    public void fill(MetalsAndColors metalsAndColors) {
        summary.stream()
                .filter(number -> number.getValue().equals(metalsAndColors.getSummaryStringValue(0))
                        || number.getValue().equals(metalsAndColors.getSummaryStringValue(1)))
                .forEach(HasClick::click);

        elements.stream()
                .filter(element -> metalsAndColors.getElements().contains(element.getValue()))
                .forEach(HasClick::click);

        colors.select(metalsAndColors.getColor());
        metals.select(metalsAndColors.getMetals());
        vegetables.select(vegetables.selected());
        metalsAndColors.getVegetables().forEach(vegetable -> vegetables.select(vegetable));
    }
}
