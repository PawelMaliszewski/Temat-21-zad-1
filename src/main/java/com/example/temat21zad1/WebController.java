package com.example.temat21zad1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebController {

    private final ProductRepository productRepo;

    public WebController(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("prodCategory", ProductCategory.values());
        return "index";
    }

    @GetMapping("/productList")
    String home(@RequestParam(required = false) String cat, Model model) {
        model.addAttribute("prodCategory", ProductCategory.values());
        List<Product> products;
        if (cat != null) {
            products = productRepo.listByProductCategory(ProductCategory.valueOf(cat));
        } else {
            products = productRepo.getProducts();
        }
        if (products.size() > 0) {
            model.addAttribute("products", products);
            model.addAttribute("totalPrice", productRepo.totalPrice(products));
        } else {
            model.addAttribute("listEmpty", "Brak produktów");
        }
        return"productList";
    }

    @GetMapping("/addProduct")
    String addAnimal(Model model) {
        Product product =  new Product();
        model.addAttribute("product", product);
        model.addAttribute("prodCategory", ProductCategory.values());
        return "addProduct";
    }

    @PostMapping("/saveProduct")
    String saveAnimal(@ModelAttribute Product product) {
        productRepo.addProductToTheList(product);
        return "redirect:/productList?cat=" + product.getProductCategory();
    }
}

