package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Nokia6300",1500000,"12gb - 2sim","Nokia"));
        products.put(2,new Product(2,"Nokia1280",500000,"4gb - 1sim","Nokia"));
        products.put(3,new Product(3,"ZFow3",10000000,"12gb - 2sim","Samsung"));
        products.put(4,new Product(4,"iphone13",21000000,"12gb - 2sim","Iphone"));
    }
    @Override
    public List<Product> showAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        ArrayList<Product> arrayList = new ArrayList();

        if(products.size() == 0){
            return arrayList;
        }
        for(Product product : products.values()){
            if(product.getName().contains(name))
                arrayList.add(product);
        }

        return arrayList;
    }
}
