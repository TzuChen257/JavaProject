package com.service;

public class QuotationService {
    private String description;
    private int defaultPrice;

    public QuotationService(String description, int defaultPrice) {
        this.description = description;
        this.defaultPrice = defaultPrice;
    }

    public String getDescription() {
        return description;
    }

    public int getDefaultPrice() {
        return defaultPrice;
    }

    @Override
    public String toString() {
        // 如果價格為 0，只顯示名稱（通常代表需議價或免費），否則顯示名稱 + 價格
        return defaultPrice > 0 ? description + " ($" + defaultPrice + ")" : description;
    }
}
