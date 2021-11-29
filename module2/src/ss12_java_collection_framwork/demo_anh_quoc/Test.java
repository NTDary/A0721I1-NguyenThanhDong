package ss12_java_collection_framwork.demo_anh_quoc;

import java.util.Scanner;

public class Test {
    private static Scanner scanner= new Scanner(System.in);
    private static ContactService contactService= new ContactService();

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("1. Create new contact\n2. Edit a contact\n3. Delete a contact\n4. Display list contact\n5. Search by name\n6. Sort by name");
        int choice= 0;
        String tmp= "";
        do{
            System.out.print(tmp==""? "Input your choice: ": "Input from 1 to 6: ");
            tmp= scanner.nextLine();
            if(Validation.isNumber(tmp))
                choice= Integer.parseInt(tmp);

        }while (choice<=0 || choice> 6);

        switch (choice){
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
                display();
                break;
            case 5:
                search();
                break;
            case 6:
                sort();
                break;
        }

        backToMainMenu();
    }

    private static void backToMainMenu(){
        System.out.print("Do you to back to main menu (Y/N): ");
        String anwser= scanner.nextLine();
        if(anwser.equalsIgnoreCase("y")) displayMainMenu();
        else System.exit(0);
    }

    private static void create() {
        inputAndSave(0);
    }

    private static void edit() {
        display();
        System.out.print("Choice contact id to edit: ");
        int id= Integer.parseInt(scanner.nextLine());
        inputAndSave(id);
    }

    private static void inputAndSave(int id) {
        System.out.print("Name: ");
        String name= scanner.nextLine();


        System.out.print("Description: ");
        String des= scanner.nextLine();
        Contact contact= new Contact(id, name, des);
        contactService.save(contact);
        System.out.println(id>0? "Updated successful": "Created successful");
    }

    private static void delete(){
        display();
        System.out.print("Choice contact id to delete: ");
        int id= Integer.parseInt(scanner.nextLine());
        contactService.delete(id);
        System.out.println("Deleted successfull");
    }

    private static void display() {
        contactService.getAll().forEach(System.out::println);
    }

    private static void search(){
        System.out.print("Input name to search: ");
        String name= scanner.nextLine();
        contactService.searchByName(name).forEach(System.out::println);
    }

    private static void sort(){
        contactService.sort().forEach(System.out::println);
    }
}
