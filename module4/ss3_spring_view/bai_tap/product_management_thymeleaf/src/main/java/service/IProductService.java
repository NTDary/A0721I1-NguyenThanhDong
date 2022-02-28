package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void save(Product product);
    Product findById(int id);
    void deleteProduct(int id);
    List<Product> findByName(String name);
}
