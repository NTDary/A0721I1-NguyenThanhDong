package ss12_java_collection_framwork.test1;

public class Book {
    private int id;
    private String name;
    private String author;
    private double price;
    private String description;

    public Book(int id, String name, String author, double price, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public String toString() {
        return id+ ","+ name+ ","+ author+ ","+ price+ ","+ description;
    }

//    String toCsv(){
//        return id+ ","+ name+ ","+ author+ ","+ price+ ","+ description;
//    }
}
