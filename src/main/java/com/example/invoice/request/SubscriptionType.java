package com.example.invoice.request;

public enum SubscriptionType {

    DAILY("daily"), WEEKLY("weekly"), MONTHLY("monthly");

    private final String value;

    SubscriptionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
