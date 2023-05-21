class Book extends Product {
    private String Author;
    private int YearPublication;
    private int Edition;

    public Book(String title, boolean status) {
        this.Title = title;
        this.Status = status;
    }

    public Book(String title, boolean status, String author, int yearPublication, int edition) {
        this.Title = title;
        this.Status = status;
        this.Author = author;
        this.YearPublication = yearPublication;
        this.Edition = edition;
    }

    public String getAuthor() {
        return this.Author;
    }

    public int getYearPublication() {
        return this.YearPublication;
    }

    public int getEdition() {
        return this.Edition;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public void setYearPublication(int yearPublication) {
        this.YearPublication = yearPublication;
    }

    public void setEdition(int edition) {
        this.Edition = edition;
    }

    public void setTitle(String title, int edition) {
        this.Title = title;
        this.Edition = edition;
    }

    @Override
    public String productDetails() {
        String productDetails = "Title: " + this.Title + " Autor: " + this.Author + " Ano de publicação: "
                + this.YearPublication + " Status: " + this.getStatus();
        return productDetails;
    }
}
