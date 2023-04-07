import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        //Author author01 = new Author("JK Rowling", "BR");

        //Book book01 = new Book("Harry Potter e a Pedra Filosofal", author01, 1997, true);
        //Book book02 = new Book("Harry Potter e a Camara Secreta", author01, 2000, true);
        //Book book03 = new Book("Harry Potter e o Prisioneiro de Askaban", author01, 2002, true);

        Library library = new Library();


        //library.getListBooks();

        int option = getOptions();
        int count = 0;
        while(option != 5) {
            switch (option) {
                case 1:
                    count++;
                    if (count == 2) {
                        System.out.println("Não é possível adicionar mais livros a livraria");
                        option = getOptions();
                        return;
                    }

                    String title = getBookTitle();
                    Author author = getBookAuthor();
                    int yearPublication = getBookYearPublication();
                    Book book = new Book(title, author, yearPublication, true);

                    library.addBook(book);
                    option = getOptions();
                    break;
                case 2:
                    System.out.println(option);
                    List books = library.getListBooks();
                    System.out.println("Livros disponíveis: " + books);
                    option = getOptions();
                    break;
                case 3:
                    title = getBookTitle();
                    author = getBookAuthor();
                    yearPublication = getBookYearPublication();
                    book = new Book(title, author, yearPublication, true);

                    System.out.println(library.toLoanBook(book));
                    option = getOptions();
                    break;
                case 4:
                    System.out.println(option);
                    option = getOptions();
                    break;
                case 5:
                    System.out.println(option);
                    break;

            }
        }


    }

    public static int getOptions() {
        String message = "LIVRARIA \nMenu de opções: \n[1] - Cadastrar livro \n[2] - Listar livros disponíveis \n[3] - Emprestar livro \n[4] - Devolver livro \n[5] - Sair \nDigite uma opção: ";
        Scanner userOption = new Scanner(System.in);
        System.out.println(message);
        int option = userOption.nextInt();

        while (option <= 0 || option > 6) {
            System.out.println("Opção inválida. \nDigite novamente: ");
            userOption = new Scanner(System.in);
            option = userOption.nextInt();
        }

        return option;
    }

    public static String getBookTitle() {
        String message = "Digite o titulo do livro: ";
        Scanner title = new Scanner(System.in);
        System.out.println(message);
        String titleBook = title.nextLine();

        return titleBook;
    }

    public static Author getBookAuthor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do autor: ");
        String authorName = scanner.nextLine();

        System.out.println("Digite a nacionalidade: ");
        String authorNacionality = scanner.nextLine();

        Author author = new Author(authorName, authorNacionality);

        return author;
    }

    public static int getBookYearPublication() {
        String message = "Digite o ano de lançamento: ";
        Scanner year = new Scanner(System.in);
        System.out.println(message);
        int bookYearPublication = year.nextInt();

        return bookYearPublication;
    }
}