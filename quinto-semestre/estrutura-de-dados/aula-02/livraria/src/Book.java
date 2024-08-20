public class Book {
    private String title;
    private String author;
    private int numPages = 0;
    private boolean available = true;

    public Book(String title, String author, int numPages, boolean available) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.available = available;
    }

    public void printDetails() {
        System.out.println(
                String.format("Título: %s, Autor: %s, Número de páginas: %d, Disponível: %b",
                        this.title,
                        this.author,
                        this.numPages,
                        this.available));
    }

    public void reserve() {
        if (this.available == false) {
            System.out.println("Livro indisponível");
            return;
        }

        this.available = false;
        System.out.println("Livro reservado com sucesso");
    }

    public void giveBack() {
        this.available = true;
        System.out.println("Devolução confirmada com sucesso");
    }

    public boolean isAvailable() {
        return available;
    }

}
