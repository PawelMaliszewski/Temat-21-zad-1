package com.example.temat21zad1;

import java.util.Arrays;

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

    static ProductCategory formLinkDescription(String category) {
        for (ProductCategory pc : ProductCategory.values()) {
            if (pc.linkDescription.equals(category)) {
                return pc;
            }
        }
        throw new IllegalArgumentException();
    }
}
