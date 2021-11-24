package com.epam.tc.hw7.site.pages.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.tc.hw7.entities.MainContent;

public class MainContentForm extends Form<MainContent> {

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

    @Override
    public void fill(MainContent mainContent) {
        summary.stream()
                .filter(number -> number.getValue().equals(mainContent.getSummaryStringValue(0))
                        || number.getValue().equals(mainContent.getSummaryStringValue(1)))
                .forEach(HasClick::click);

        elements.stream()
                .filter(element -> mainContent.getElements().contains(element.getValue()))
                .forEach(HasClick::click);

        colors.select(mainContent.getColor());
        metals.select(mainContent.getMetals());
        vegetables.select(vegetables.selected());
        mainContent.getVegetables().forEach(vegetable -> vegetables.select(vegetable));
    }
}
