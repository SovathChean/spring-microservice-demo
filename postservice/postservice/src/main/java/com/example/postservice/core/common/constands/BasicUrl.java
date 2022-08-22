package com.example.postservice.core.common.constands;

public enum BasicUrl {
    BASIC_TEST_URI("http://localhost:%s/api/"),
    POST("posts");
    public final String label;
    BasicUrl(String label) {
        this.label = label;
    }
}
