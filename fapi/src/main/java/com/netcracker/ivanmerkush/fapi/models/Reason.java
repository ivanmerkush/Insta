package com.netcracker.ivanmerkush.fapi.models;

public enum Reason {
    SPAM("Spam"), OBSCENITY("Obscenity");
    private String name;
    Reason(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
