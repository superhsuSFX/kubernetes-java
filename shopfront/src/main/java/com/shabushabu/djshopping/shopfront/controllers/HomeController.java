package com.shabushabu.djshopping.shopfront.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.shabushabu.djshopping.shopfront.services.ProductService;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    
/*    @RequestMapping("/")
    public String index(Model model) {
	model.addAttribute("products", productService.getProducts());
        return "index";
    }
*/    
    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
	return "register_form";
    }
	
    @PostMapping("/register")
        public String submitForm(@ModelAttribute("user") User user) {
		//System.out.println(user);
	    return "redirect:register/success";
    }

    @RequestMapping("/success")
    public String index(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "product_index";
    }

	
}
