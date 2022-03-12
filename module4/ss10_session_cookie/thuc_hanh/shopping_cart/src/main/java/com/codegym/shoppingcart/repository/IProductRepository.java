package com.codegym.shoppingcart.repository;


import com.codegym.shoppingcart.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
