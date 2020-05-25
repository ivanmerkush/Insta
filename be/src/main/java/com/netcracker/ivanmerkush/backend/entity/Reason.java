package com.netcracker.ivanmerkush.backend.entity;

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
