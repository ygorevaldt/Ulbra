public class Author {
    private String name;
    private String nacionality;

    public Author(String name, String nacionality) {
        this.name = name;
        this.nacionality = nacionality;
    }

    public String getName() {
        return this.name;
    }

    public String getNacionality() {
        return this.nacionality;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }
}
