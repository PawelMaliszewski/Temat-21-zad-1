package com.example.temat21zad1;

public enum ProductCategory {
    FOOD("Art. spożywcze"),
    HOUSE_HOLD("Art. gosp. domowego"),
    AGRICULTURE("Art. rolne"),

    CHEMICAL("Art. chemiczne");

    private final String description;

    ProductCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
