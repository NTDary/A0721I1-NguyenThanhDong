package ss12_java_collection_framwork.bai_tap.arraylist_linkedlist;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private int price;
    private int quantity;

    public Product(){

    }
    public Product(int id, String name,int price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id= " + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Product product) {
        return  product.getPrice() - this.price;
    }
}
