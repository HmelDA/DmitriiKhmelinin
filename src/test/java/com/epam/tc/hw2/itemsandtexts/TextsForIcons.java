package com.epam.tc.hw2.itemsandtexts;

public enum TextsForIcons {
    MICROSCOPE_TEXT("To include good practices\nand ideas from successful\nEPAM project"),
    HEADPHONES_TEXT("To be flexible and\n"
            + "customizable"),
    MONITOR_TEXT("To be multiplatform"),
    ROCKET_TEXT("Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");

    String text;

    TextsForIcons(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
