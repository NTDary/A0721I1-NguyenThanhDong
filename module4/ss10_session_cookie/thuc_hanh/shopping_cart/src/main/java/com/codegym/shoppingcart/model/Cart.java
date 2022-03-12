package com.codegym.shoppingcart.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    //create contructor Cart co tham so products
    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }


    //create method getProducts
    public Map<Product, Integer> getProducts() {
        return products;
    }

    //create method check item in cart
    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }

    //create method select all items in Cart and return product
    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    //create method add Product to
    public void addProduct(Product product) {
        //check product not in Cart => add new products(key,value): key = product name, value = quantity
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            //if product in cart => getValue() + 1 : getValue() = quantity product
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            //replace thay the value cua key chi dinh thanh value khac
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void divProduct(Product product) {
        if (checkItemInCart(product)) {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            if (itemEntry.getValue() == 1) {
                products.remove(itemEntry.getKey());
            } else {
                Integer newQuantity = itemEntry.getValue() - 1;
                products.replace(itemEntry.getKey(), newQuantity);
            }
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        //dung entrySet() de tra ve gap key value
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
