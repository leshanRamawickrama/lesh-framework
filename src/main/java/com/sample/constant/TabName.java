package com.sample.constant;

public enum TabName {
    BOOK("Books");

    public String getTitle() {
        return title;
    }

    private String title;

    TabName(String title) {
        this.title = title;
    }
}
