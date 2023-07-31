package com.example.temat21zad1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("Mleko", 3.99, ProductCategory.FOOD));
        products.add(new Product("Chleb", 4.49, ProductCategory.FOOD));
        products.add(new Product("Marchewka", 5.59, ProductCategory.FOOD));
        products.add(new Product("Mięso", 25.99, ProductCategory.FOOD));
        products.add(new Product("Nawóz do kwiatków", 9.99, ProductCategory.AGRICULTURE));
        products.add(new Product("Ziemia dla roślin doniczkowych", 7.99, ProductCategory.AGRICULTURE));
        products.add(new Product("Doniczka", 4.99, ProductCategory.AGRICULTURE));
        products.add(new Product("Mop", 23.99, ProductCategory.HOUSE_HOLD));
        products.add(new Product("Płyn do mycia naczyń", 7.69, ProductCategory.HOUSE_HOLD));
        products.add(new Product("Gąbka", 1.89, ProductCategory.HOUSE_HOLD));
        products.add(new Product("Mydło", 2.59, ProductCategory.HOUSE_HOLD));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public void addProductToTheList(Product product) {
        if (product != null) {
            products.add(product);
        } else {
            throw new NullPointerException("Wartość nie może byc null");
        }
    }

    public List<Product> listByProductCategory(ProductCategory productCategory) {
        return products.stream()
                .filter(product -> product.getProductCategory() == productCategory)
                .collect(Collectors.toList());
    }

    public double totalPrice(List<Product> products) {
        return (double) Math.round(products.stream()
                                           .map(Product::getPrice)
                                           .reduce(0.00, Double::sum) * 100) / 100;
    }
}
