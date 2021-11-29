package ss12_java_collection_framwork.test1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BookService {
    private static List<Book> books= new ArrayList<>();
    private CSVHelper<Book> csvHelper= new CSVHelper();
    private final String path= "src\\test\\book_managerment\\books.csv";

    BookService(){
        books= getAll();
    }

    List<Book> getAll() {
        books.clear();
        List<String> lines= csvHelper.read(path);
        for (String line: lines){
            String[] tmp= line.split(",");
            int id= Integer.parseInt(tmp[0]);
            String name= tmp[1];
            String author= tmp[2];
            double price= Double.parseDouble(tmp[3]);
            String des= tmp[4];
            Book book= new Book(id, name, author, price, des);
            books.add(book);
        }
        return books;
    }

    void save(Book book) {
        if(book.getId()> 0){
            int index= books.indexOf(book);
            books.set(index, book);
        }
        else {
            book.setId(books.size() + 1);
            books.add(book);
        }

        csvHelper.write(books, path);
    }

    void delete(int id){
        int size= books.size();
        for (int i = 0; i < size; i++) {
            if(id== books.get(i).getId())
                books.remove(i);
        }

        csvHelper.write(books, path);
    }

    void show(List<Book> books){
        // no - align right, - align left
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s%n", "ID", "NAME", "AUTHOR", "PRICE", "DESCRIPTION");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (Book book : books){
            System.out.format("%-10d %-20s %-20s %-20.2f %-20s%n", book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getDescription());
        }
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    void show(){
        show(books);
    }

    List<Book> searchByName(String name){
        return books.stream().filter(e-> e.getName().contains(name)).collect(Collectors.toList());
    }

    List<Book> searchFromPrice(double price){
        return books.stream().filter(e-> e.getPrice()> price).collect(Collectors.toList());
    }

    void sort(){
        Collections.sort(books, Comparator.comparing(Book::getPrice));
    }
}
