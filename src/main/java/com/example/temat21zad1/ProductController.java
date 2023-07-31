package com.example.temat21zad1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @GetMapping("/lista")
    String productList(@RequestParam(required = false) String kategoria, Model model) {
        List<Product> products;
        if (kategoria != null) {
            products = productRepository.listByProductCategory(kategoria);
        } else {
            products = productRepository.getAllProducts();
        }
        model.addAttribute("products", products);
        model.addAttribute("totalPrice", productRepository.totalPrice(products));
        return "lista";
    }

    @GetMapping("/dodajProdukt")
    String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "dodajProdukt";
    }

    @PostMapping("/saveProduct")
    String saveProduct(@ModelAttribute Product product) {
        productRepository.addProductToTheList(product);
        return "redirect:/lista?kategoria=" + product.getProductCategory().getLinkDescription();
    }
}

