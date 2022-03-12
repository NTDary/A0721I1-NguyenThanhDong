package com.codegym.shopingcart.repository;

import com.codegym.shopingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
