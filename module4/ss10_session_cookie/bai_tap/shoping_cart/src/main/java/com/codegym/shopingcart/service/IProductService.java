package com.codegym.shopingcart.service;

import com.codegym.shopingcart.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
