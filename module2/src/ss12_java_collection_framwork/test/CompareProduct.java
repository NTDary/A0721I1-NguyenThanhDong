package ss12_java_collection_framwork.test;

import java.util.Comparator;

public class CompareProduct implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return (int)(p1.getPrice() - p2.getPrice()); //tăng dần
        //return (int)(p2.getPrice() - p1.getPrice()); // giảm dần
    }
}
