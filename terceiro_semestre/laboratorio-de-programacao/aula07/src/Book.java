public class Book {
    private String title;
    private Author author;
    private int yearPublication;
    private boolean available;

    public Book(String title, Author author, int yearPublication, boolean available) {
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
        this.available = available;
    }

    public String getTitle() {
        return this.title;
    }

    public Author getAuthor() {
        return this.author;
    }

    public int getYearPublication() {
        return this.yearPublication;
    }

    public boolean getAvailable() {
        return this.available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void toLoan() {
        this.available = false;
    }

    public void giveBack() {
        this.available = true;
    }
}
