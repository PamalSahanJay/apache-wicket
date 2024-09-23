package org.example;

public enum HttpFilterOrder {
    COMPRESS_FILTER,
    WICKET_SESSION_FILTER,
    REQUEST_LOGGING_FILTER,
    WICKET_FILTER,
    SITE_MECH_FILTER,
    DISPLAY_TAG_FILTER;

    private int order;

    HttpFilterOrder() {
    }

    HttpFilterOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order != 0 ? order : ordinal();
    }
}
