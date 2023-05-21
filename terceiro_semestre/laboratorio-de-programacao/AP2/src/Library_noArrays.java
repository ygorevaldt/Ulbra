
public class Library_noArrays {
    private String Name;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;

    public Library_noArrays(String name) {
        this.Name = name;
    }

    public void addBook(Book book) {
        if (this.book1 == null) {
            this.book1 = book;
            return;
        }
        if (this.book2 == null){
            this.book2 = book;
            return;
        }
        if (this.book3 == null) {
            this.book3 = book;
            return;
        }
        if (this.book4 == null){
            this.book4 = book;
            return;
        }
        if(this.book5 == null) {
            this.book5 = book;
            return;
        }

        this.book1 = book;
    }

    public void removeBook(Book book) {
        if (this.book1 == book) {
            this.book1 = null;
            return;
        }
        if (this.book2 == book){
            this.book2 = null;
            return;
        }
        if (this.book3 == book) {
            this.book3 = null;
            return;
        }
        if (this.book4 == book){
            this.book4 = null;
            return;
        }
        if (this.book5 == book) {
            this.book5 = null;
        }

        this.book5 = null;
    }

    public void updateBookDetails(Book book) {
        if (this.book1.getTitle() == book.getTitle()) {
            this.book1 = book;
            return;
        }
        if (this.book2.getTitle() == book.getTitle()){
            this.book2 = book;
            return;
        }
        if (this.book3.getTitle() == book.getTitle()) {
            this.book3 = book;
            return;
        }
        if (this.book4.getTitle() == book.getTitle()) {
            this.book4 = book;
            return;
        }
        if (this.book5.getTitle() == this.book5.getTitle()) {
            this.book5 = book;
        }
    }

    public void showAllBooks() {
        if (this.book1 != null) {
            System.out.println("Titulo: " + book1.getTitle() + " Autor: " + book1.getAuthor() + " Status: " + book1.getStatus() + " Ano de publicação: " + book1.getYearPublication() + " Edição: " + book1.getEdition());
        }
        if (this.book2 != null){
            System.out.println("Titulo: " + book2.getTitle() + " Autor: " + book2.getAuthor() + " Status: " + book2.getStatus() + " Ano de publicação: " + book2.getYearPublication() + " Edição: " + book2.getEdition());
        }
        if (this.book3 != null) {
            System.out.println("Titulo: " + book3.getTitle() + " Autor: " + book3.getAuthor() + " Status: " + book3.getStatus() + " Ano de publicação: " + book3.getYearPublication() + " Edição: " + book3.getEdition());
        }
        if (this.book4 != null){
            System.out.println("Titulo: " + book4.getTitle() + " Autor: " + book4.getAuthor() + " Status: " + book4.getStatus() + " Ano de publicação: " + book4.getYearPublication() + " Edição: " + book4.getEdition());
        }
        if(this.book5 != null) {
            System.out.println("Titulo: " + book5.getTitle() + " Autor: " + book5.getAuthor() + " Status: " + book5.getStatus() + " Ano de publicação: " + book5.getYearPublication() + " Edição: " + book5.getEdition());
        }
    }

    public String checkProductStatus(Book book) {
        return "O livro " + book.getTitle() + " está " + book.getStatus();
    }

}
