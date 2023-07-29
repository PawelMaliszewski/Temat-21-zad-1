package com.example.temat21zad1;

public class Product {

    private String name;
    private double price;
    private ProductCategory productCategory;

    public Product() {
    }

    public Product(String name, double price, ProductCategory productCategory) {
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
