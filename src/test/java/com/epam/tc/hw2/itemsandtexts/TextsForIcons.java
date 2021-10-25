package com.epam.tc.hw2.itemsandtexts;

public enum TextsForIcons {
    MICROSCOPE("To include good practices and ideas from successful EPAM project"),
    HEADPHONES("To be flexible and customizable"),
    MONITOR("To be multiplatform"),
    ROCKET("Already have good base (about 20 internal and some external projects), wish to get more…");

    String text;

    TextsForIcons(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
