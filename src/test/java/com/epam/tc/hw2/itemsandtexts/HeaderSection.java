package com.epam.tc.hw2.itemsandtexts;

public enum HeaderSection {

    HOME("HOME"),
    CONTACT_FORM("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS_AND_COLORS("METALS & COLORS");

    String item;

    HeaderSection(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
