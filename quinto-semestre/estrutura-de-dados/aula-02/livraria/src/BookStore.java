import java.util.ArrayList;

public class BookStore {
    private ArrayList<Book> books;

    public BookStore(ArrayList<Book> books) {
        this.books = books;
    }

    public void insertBook(Book book) {
        this.books.add(book);
    }

    public void listBooks() {
        for (Book book : this.books) {
            book.printDetails();
        }
    }

    public void listAvailables() {
        for (Book book : this.books) {
            if (book.isAvailable())
                book.printDetails();
        }
    }
}
