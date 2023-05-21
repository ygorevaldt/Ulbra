import java.util.Random;
public class Library {
    private String Name;
    private Book[] books;
    private Random random = new Random();

    public Library(String name) {
        this.Name = name;
        this.books = new Book[5];
    }

    public void addBook(Book book) {
        boolean controller = false;
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = book;
                controller = true;
                break;
            }
        }
        if (!controller) {
            int index = this.random.nextInt(6);
            this.books[index] = book;
        }
}

    public void removeBook(Book book) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == book) {
                this.books[i] = null;
                return;
            }
        }
    }

    public void updateBookDetails(Book book) {
        for (int i = 0; i < this.books.length; i++) {
            boolean check = this.books[i] != null;
            if (check) {
                boolean condition = this.books[i].getTitle() == book.getTitle();
                if (condition) {
                    this.books[i] = book;
                    return;
                }
            }
        }
    }

    public void showAllBooks() {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] != null) {
                String details = "Titulo: " + books[i].getTitle() + " Autor: " + books[i].getAuthor() + " Status: " + books[i].getStatus() + " Ano de publicação: " + books[i].getYearPublication() + " Edição: " + books[i].getEdition();
                System.out.println(details);
            }
        }
    }

    public String checkProductStatus(Book book) {
        return "O livro " + book.getTitle() + " está " + book.getStatus();
    }

}
