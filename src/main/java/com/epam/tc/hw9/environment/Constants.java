package com.epam.tc.hw9.environment;

public enum Constants {
    KEY("74ecb1e868a46b2e1513f84af0e8ac6a"),
    TOKEN("92c25dda00b665a0fe64f4fcdd999f862ac9e6fdbdef1e84f3b4093cc7a93199"),
    BASE_URL("https://api.trello.com");


    private String constant;

    private Constants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
