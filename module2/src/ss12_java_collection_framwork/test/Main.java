package ss12_java_collection_framwork.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        ProductManager product = new ProductManager();
        System.out.println("____________MENU______________");
        do {
            System.out.println("YOUR OPTION");
            System.out.println("----------------------------");
            System.out.println("1.Add new Product!");
            System.out.println("2.Display All Product!");
            System.out.println("3.Edit your Product!");
            System.out.println("4.Delete Product!");
            System.out.println("5.Search Product!");
            System.out.println("6.Sort Product!");
            System.out.println("7.EXIT -----!");

            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("---------ADD---------");
                    product.addProduct();
                    break;
                case 2:
                    System.out.println("---------DISPLAY--------");
                    product.displayProduct();
                    break;
                case 3:
                    System.out.println("---------EDIT--------");
                    product.editProductById();
                    product.displayProduct();
                    break;
                case 4:
                    System.out.println("---------DELETE--------");
                    product.deleteProductById();
                    product.displayProduct();
                    break;
                case 5:
                    System.out.println("---------SEARCH--------");
                    product.searchProductByName();
                    break;
                case 6:
                    System.out.println("---------SORT--------");
                    product.sort();
                    product.displayProduct();
                    break;
                default:
                    check = false;
            }
        } while (check);
    }
}
