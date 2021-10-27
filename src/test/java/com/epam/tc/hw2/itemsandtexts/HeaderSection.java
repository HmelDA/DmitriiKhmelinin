package com.epam.tc.hw2.itemsandtexts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum HeaderSection {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    String item;
    private final String value;

    private static final List<String> VALUES;


    static {
        VALUES = new ArrayList<>();
        for (HeaderSection headerSection : HeaderSection.values()) {
            VALUES.add(headerSection.value);
        }
    }

    private HeaderSection(String value) {
        this.value = value;
    }

    public static List<String> getValues() {
        return Collections.unmodifiableList(VALUES);
    }
}