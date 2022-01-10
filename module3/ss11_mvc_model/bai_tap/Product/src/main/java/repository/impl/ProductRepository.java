package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Ao Polo", "nam", "ThaiLan"));
        products.add(new Product(2, "Ao So Mi", "nu", "Vietnam"));
        products.add(new Product(3, "Quan The Thao", "nam", "Vietnam"));
        products.add(new Product(4, "Giay Luoi", "nam", "Hàn Quốc"));
    }


    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for(Product product: products){
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                products.set(i, product);
            }
        }

    }

    @Override
    public void remove(int id) {
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getId() == id){
                products.remove(i);
            }
        }
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> temp = new ArrayList<>();
        for(int i=0; i < products.size(); i++){
            if(products.get(i).getName().contains(name)){
                temp.add(products.get(i));
            }
        }
        return temp;
    }
}
