public class Book {
    private String Title;
    private String Author;
    private double Price;

    public Book(String title, String author, double price) {
        this.Title = title;
        this.Author = author;
        this.Price = price;
    }

    public Book(String title, String author) {
        this.Title = title;
        this.Author = author;
        this.Price = 0.00;
    }
}
