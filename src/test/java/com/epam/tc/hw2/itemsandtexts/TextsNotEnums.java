package com.epam.tc.hw2.itemsandtexts;

import org.openqa.selenium.By;

import java.util.List;

public class TextsNotEnums {
    public static String HEADER_SECTION = "HOME\nCONTACT FORM\nSERVICE\nMETALS & COLORS";

    public static List<String> TEXTS_FOR_BENEFITS = List.of(
            "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project",

            "To be flexible and\n"
            + "customizable",

            "To be multiplatform",

            "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…"
    );

    public static List<String> LEFT_SECTION = List.of(
            "Home",
            "Contact form",
            "Service",
            "Metals & Colors",
            "Elements packs"
    );

    public static final String FRAME_BUTTON_IFRAME = "frame";

    public static final String FRAME_BUTTON_VALUE = "value";

    public static final String FRAME_BUTTON_TEXT = "Frame Button";
}
