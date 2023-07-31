package com.example.temat21zad1;

public enum ProductCategory {
    FOOD("Art. spożywcze", "spozywcze"),
    HOUSE_HOLD("Art. gosp. domowego", "domowego"),
    AGRICULTURE("Art. rolne", "rolne"),
    CHEMICAL("Art. chemiczne", "chemiczne");

    private final String description;
    private final String linkDescription;

    ProductCategory(String description, String linkDescription) {
        this.description = description;
        this.linkDescription = linkDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getLinkDescription() {
        return linkDescription;
    }
}
