public class App {
    public static void main(String[] args) throws Exception {
        // AP2 VERSÃO COM ARRAYS
        System.out.println("AP2 VERSÃO COM ARRAYS");
        Book book1 = new Book("Hp - Pedra filosofal", true);
        Book book2 = new Book("Hp - Camara secreta", true);
        Book book3 = new Book("Hp - O prisioneiro de askaban", true);
        Book book4 = new Book("Hp - Calice de fogo", true);
        Book book5 = new Book("Hp - Ordem da fenix", true);
        Book book6 = new Book("Hp - Enigma do príncipe", true);

        book5.setAuthor("JK");
        book5.setEdition(2);
        book5.setYearPublication(2001);
        book5.setTitle("Hp - Ordem da fenix", 1);
        book5.productDetails();

        Library devLibrary = new Library("Livraria Nem Lí nem Lerei");
        devLibrary.addBook(book1);
        devLibrary.addBook(book2);
        devLibrary.addBook(book3);
        devLibrary.addBook(book4);
        devLibrary.addBook(book5);
        devLibrary.addBook(book6);

        devLibrary.removeBook(book1);

        devLibrary.showAllBooks();
        System.out.println("-----------------------------------------------------------------------------------");

        Book book6Update = new Book("Hp - Enigma do príncipe", true, "JK", 2000, 1);
        devLibrary.updateBookDetails(book6Update);
        devLibrary.showAllBooks();

        System.out.println(devLibrary.checkProductStatus(book2));

        // AP2 VERSÃO SEM ARRAYS
        System.out.println("\nAP2 VERSÃO SEM ARRAYS");
        Library_noArrays devLibraryNoArrays = new Library_noArrays(("Lí e lerei"));
        devLibraryNoArrays.addBook(book1);
        devLibraryNoArrays.addBook(book2);
        devLibraryNoArrays.addBook(book3);
        devLibraryNoArrays.addBook(book4);
        devLibraryNoArrays.addBook(book5);
        devLibraryNoArrays.addBook(book6);

        devLibraryNoArrays.removeBook(book1);

        devLibraryNoArrays.showAllBooks();
        System.out.println("-----------------------------------------------------------------------------------");

        Book book2Update = new Book("Hp - Enigma do príncipe", true, "JK", 2000, 1);
        devLibraryNoArrays.updateBookDetails(book2Update);
        devLibraryNoArrays.showAllBooks();

        System.out.println(devLibraryNoArrays.checkProductStatus(book2));

    }
}
