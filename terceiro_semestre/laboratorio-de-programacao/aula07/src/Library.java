import java.util.List;
import java.util.ArrayList;

public class Library {
    private Book book01;
    private Book book02;
    private Book book03;

    public void addBook(Book book) {
        if (this.book01 == null) {
            this.book01 = book;
        }
        else if(this.book02 == null) {
            this.book02 = book;
        }
        else if (this.book03 == null) {
            this.book03 = book;
        }

        System.out.println("Livro " + book.getTitle() + " adicionado com sucesso.");
    }

    public void removeBook(Book book) {
        if (this.book01 == book) {
            this.book01 = null;
        }
        else if(this.book02 == book) {
            this.book02 = null;
        }
        else if(this.book03 == book) {
            this.book03 = null;
        }
    }

    public String toLoanBook(Book book) {
        if (this.book01 == book && this.book01.getAvailable()) {
            this.book01.toLoan();
            return "Livro " + this.book01.getTitle() + " emprestado";
        }
        else if(this.book02 == book && this.book02.getAvailable()) {
            this.book02.toLoan();
            return "Livro " + this.book02.getTitle() + " emprestado";
        }
        else if(this.book03 == book && this.book03.getAvailable()) {
            this.book03.toLoan();
            return "Livro " + this.book03.getTitle() + " emprestado";
        }

        return "O livro " + book.getTitle() + " não foi encontrado na livraria";
    }

    public void giveBackBook(Book book) {
        if (this.book01 == book && !this.book01.getAvailable()) {
            this.book01.giveBack();
        }
        else if(this.book02 == book && !this.book02.getAvailable()) {
            this.book02.giveBack();
        }
        else if(this.book03 == book && !this.book03.getAvailable()) {
            this.book03.giveBack();
        }
    }

    public List getListBooks() {
        List<Book> books = new ArrayList<>();
        books.add(this.book01);
        books.add(this.book02);
        books.add(this.book03);

        List <String> booksAvailable = new ArrayList<>();
        for (Book book : books) {
            if (book != null) {
                if (book.getAvailable()) {
                    booksAvailable.add(book.getTitle());
                }
            }
        }

        return booksAvailable;
    }

}