package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> searchByName(String name);
    void save(Product product);
    void update(int id, Product product);
    Product findById(int id);
    void remove(int id);

}
