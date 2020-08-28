package com.shabushabu.djshopping.shopfront.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shabushabu.djshopping.shopfront.services.ProductService;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "index";
    }
}
