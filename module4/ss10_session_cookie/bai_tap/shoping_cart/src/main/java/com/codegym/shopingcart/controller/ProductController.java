package com.codegym.shopingcart.controller;


import com.codegym.shopingcart.model.Cart;
import com.codegym.shopingcart.model.Product;
import com.codegym.shopingcart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ModelAndView("error.404");
        }else {
            return new ModelAndView("product","product",productOptional.get());
        }
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "error.404";
        }
        switch (action){
            case "show":
                cart.addProduct(productOptional.get());
                return "redirect:/shopping-cart";
            case "-":
                cart.divProduct(productOptional.get());
                return "redirect:/shopping-cart";
            case "delete":
                cart.deleteProduct(productOptional.get());
                return "redirect:/shopping-cart";
//            case "list":
//                cart.addProduct(productOptional.get());
//                return "redirect:/shop";
        }
//        if (action.equals("show")) {
//            cart.addProduct(productOptional.get());
//            return "redirect:/shopping-cart";
//        }else if(action.equals("-")){
//            cart.divProduct(productOptional.get());
//            return "redirect:/shopping-cart";
//        }
//        cart.addProduct(productOptional.get());
//        return "redirect:/shop";
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}
