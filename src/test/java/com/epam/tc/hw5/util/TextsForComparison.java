package com.epam.tc.hw5.util;

import java.util.List;

public class TextsForComparison {

    public static String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public static String DIFFERENT_ELEMENTS_URL = "https://jdi-testing.github.io/jdi-light/different-elements.html";


    public static String HOME_PAGE = "Home Page";

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

    public static final List<String> LOG_CHANGES = List.of(
            "Colors: value changed to Yellow",
            "metal: value changed to Selen",
            "Wind: condition changed to true",
            "Water: condition changed to true"
    );
}
