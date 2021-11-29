package ss12_java_collection_framwork.test1;

import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static BookService bookService = new BookService();

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.print("1. Create new book\n2. Edit a book\n3. Delete a book\n4. Display list book\n5. Search By Name" +
                "\n6. Search From Price\n7 Sort By Price\n8. Exit\n");
        String tmp = "";
        int choice = 0;
        do {
            System.out.print(tmp.isEmpty() ? "Input your choice: " : "Please input value from 1 to 8: ");
            tmp = scanner.nextLine();
            if (isNumber(tmp)) choice = Integer.parseInt(tmp);
        } while (choice <= 0 || choice > 8);

        switch (choice) {
            case 1:
                create();
                break;
            case 2:
                edit();
                break;
            case 3:
                delete();
                break;
            case 4:
                bookService.show();
                break;
            case 5:
                searchByName();
                break;
            case 6:
                searchFromPrice();
                break;
            case 7:
                bookService.sort();
                bookService.show();
                break;
            case 8:
                System.exit(0);
                break;
        }
        backToMainMenu();
    }

    private static void searchByName(){
        System.out.print("Input name to search: ");
        String name= scanner.nextLine();
        List<Book> books= bookService.searchByName(name);
        bookService.show(books);
    }

    private static void searchFromPrice(){
        System.out.print("Input price to search: ");
        double price= Double.parseDouble(scanner.nextLine());
        List<Book> books= bookService.searchFromPrice(price);
        bookService.show(books);
    }

    private static void delete() {
        bookService.show();
        System.out.print("Input book id to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        bookService.delete(id);
        System.out.println("Deleted successful!");
    }

    private static void edit() {
        bookService.show();
        System.out.print("Input book id to edit: ");
        int id = Integer.parseInt(scanner.nextLine());
        inputAndSave(id);
        System.out.println("Update successful!");
    }

    private static void create() {
        inputAndSave(0);
        System.out.println("Created successful!");
    }

    private static boolean isNumber(String choice) {
        try {
            Integer.parseInt(choice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void backToMainMenu() {
        System.out.print("Do you back to main menu (Y/N): ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) displayMainMenu();
        else System.exit(0);
    }

    private static void inputAndSave(int id) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Description: ");
        String des = scanner.nextLine();
        Book book = new Book(id, name, author, price, des);
        bookService.save(book);
    }
}
