package ss12_java_collection_framwork.bai_tap.arraylist_linkedlist;
import java.util.ArrayList;
import java.util.Scanner;
public class ProductManager {
    private ArrayList<Product> listProduct = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public void addProduct(){
        System.out.println("Input id Name Product");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Input Name Product");
        String name = input.nextLine();
        System.out.println("Input Price Product!");
        int price = Integer.parseInt(input.nextLine());
        System.out.println("Input Price Product!");
        int quantity = Integer.parseInt(input.nextLine());
        Product product = new Product(id,name,price,quantity);
        listProduct.add(product);
    }
    public void displayProduct(){
        for (Product pd : listProduct){
            System.out.println(pd.toString());
        }
    }
//    public void editProduct(){
//        boolean check = false;
//        int count = 0;
//        System.out.println("Input ID of Product to edit");
//        int id = Integer.parseInt(input.nextLine());
//        for(int i = 0; i < listProduct.size(); i++){
//            if(id == listProduct.get());
//        }
//    }
}
