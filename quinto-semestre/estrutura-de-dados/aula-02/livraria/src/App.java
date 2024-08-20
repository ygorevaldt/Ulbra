import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Livraria\n");

        Book elonMusk = new Book("Elon Musk", "Walter Isaacson", 878, false);
        Book oPoderDoHabito = new Book("O Poder do Hábito", "Charles Duhigg", 408, true);
        Book oMetodoPara = new Book("O Método P.A.R.A", "Tiago Forte", 206, true);

        ArrayList<Book> books = new ArrayList<>(Arrays.asList(elonMusk, oPoderDoHabito));

        BookStore bookStore = new BookStore(books);

        bookStore.insertBook(oMetodoPara);

        System.out.println("Todos os livros:");
        bookStore.listBooks();

        System.out.println("\nLivros disponíveis: ");
        bookStore.listAvailables();

    }
}
