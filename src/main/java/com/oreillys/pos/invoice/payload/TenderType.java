package com.oreillys.pos.invoice.payload;

public enum TenderType {
    CASH("cash"),
    CREDIT("credit");

    private final String type;

    private TenderType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
