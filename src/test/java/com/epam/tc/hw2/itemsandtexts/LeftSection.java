package com.epam.tc.hw2.itemsandtexts;

public enum LeftSection {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METALS_AND_COLORS("Metals & Colors"),
    ELEMENT_PACKS("Elements packs");

    String item;

    LeftSection(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
