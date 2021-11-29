package ss12_java_collection_framwork.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> productsList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    public void addProduct(){
        System.out.println("Input Id Product! ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Input Name Product!");
        String name = input.nextLine();
        System.out.println("Input Price Product!");
        int price = Integer.parseInt(input.nextLine());
        Product product = new Product(id,name,price);
        productsList.add(product);
    }
    public void displayProduct(){
        for (int i=0 ; i <productsList.size();i++){
            System.out.println(productsList.get(i));
        }
    }
    public void editProductById(){
       boolean check = false;
        int count = 0 ;
        int id = Integer.parseInt(input.next());
        for (int i = 0 ; i < productsList.size();i++){
            if (id == productsList.get(i).getId()){
                check = true;
                count = i ;
                break;
            }
        }
        if (check){
            System.out.println("Input new Id");
            int newId = Integer.parseInt(input.nextLine());
            System.out.println("Input new Name");
            String name = input.nextLine();
            System.out.println("Input new Price");
            double price = Integer.parseInt(input.nextLine());
            Product newProduct = new Product(newId,name,price);
            productsList.add(count,newProduct); /// không hiểu
            productsList.remove(count+1); /// không hiểu
        }else {
            System.out.println("Non-existence ID Product");
        }
    }
    public void deleteProductById(){
        boolean check = false;
        System.out.println("Input ID Product to Delete");
        int id = Integer.parseInt(input.nextLine());
        for (int i = 0 ; i < productsList.size();i++){
            if (id == productsList.get(i).getId()){
                check = true;
                productsList.remove(i);

            }
        }
        if (!check){
            System.out.println("Non-existence ID Product");
        }
    }
    public void searchProductByName(){
        boolean check = false;
        System.out.println("Input Name Product to Search");
        String name = input.nextLine();
        for (int i = 0 ; i < productsList.size();i++){
            if (name.equals(productsList.get(i).getName())){
                System.out.println("Your Product is ");
                System.out.println(productsList.get(i));
                check = true;
            }
        }
        if (!check){
            System.out.println("Non-existence Name Product");
        }
    }
    public void sort(){
        Collections.sort(productsList, new CompareProduct());
    }
}