package com.example.userservice.core.common.constant;

public enum BasicUrl {
    BASIC_TEST_URI("http://localhost:%s/api/"),
    USER("users");
    public final String label;
    private BasicUrl(String label) {
        this.label = label;
    }
}
