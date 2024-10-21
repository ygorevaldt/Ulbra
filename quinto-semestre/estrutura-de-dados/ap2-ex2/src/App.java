import java.util.Scanner;
import java.util.UUID;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("AP2 - Exercício 2");

        Scanner scanner = new Scanner(System.in);
        BooksList books = new BooksList();

        int action = 0;

        do {
            System.out.println("\nDigite a ação desejada\n");
            System.out.println("[1] - Adicionar livro no início");
            System.out.println("[2] - Adicionar livro no fim");
            System.out.println("[3] - Remover livro do início");
            System.out.println("[4] - Remover livro do fim");
            System.out.println("[5] - Buscar livro por ID");
            System.out.println("[6] - Exibir livros na ordem original");
            System.out.println("[7] - Exibir livros na ordem inversa");
            System.out.println("[8] - Excerrar programa");
            action = scanner.nextInt();
            scanner.nextLine();

            UUID id;
            String title;
            String author;
            Book book;

            switch (action) {
                case 1:
                    System.out.println("Adicionando novo livro no início");

                    System.out.println("Digite o título: ");
                    title = scanner.nextLine();
                    System.out.println("Digite o autor: ");
                    author = scanner.nextLine();

                    book = new Book(title, author);
                    books.insertAtStart(book);
                    break;
                case 2:
                    System.out.println("Adicionando novo livro no fim");

                    System.out.println("Digite o título: ");
                    title = scanner.nextLine();
                    System.out.println("Digite o autor: ");
                    author = scanner.nextLine();

                    book = new Book(title, author);
                    books.insertAtEnd(book);
                    break;
                case 3:
                    System.out.println("Removendo novo livro no início");
                    book = books.removeAtStart();

                    if (book == null)
                        break;

                    System.out.println("Livro removido: " + book);
                    break;
                case 4:
                    System.out.println("Removendo novo livro no fim");
                    book = books.removeAtEnd();

                    if (book == null)
                        break;

                    System.out.println("Livro removido: " + book);
                    break;
                case 5:
                    System.out.println("Buscando livro por ID");
                    System.out.println("Digite o ID:");
                    String uuidString = scanner.nextLine();

                    id = UUID.fromString(uuidString);
                    book = books.findBookById(id);
                    if (book == null) {
                        System.out.println("Livro não encontrado");
                        return;
                    }

                    System.out.println(book);
                    break;
                case 6:
                    System.out.println("Exibindo livros na ordem original");
                    books.printBooks();
                    break;
                case 7:
                    System.out.println("Exibindo livros na ordem inversa");
                    books.printBooksReverse();
                    break;
                default:
                    action = 8;
                    break;
            }
        } while (action != 8);
    }
}
