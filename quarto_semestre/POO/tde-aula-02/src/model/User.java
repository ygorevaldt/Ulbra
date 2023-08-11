package model;

public class User {
    private int id;
    private String name;

    public User (String name) {
        this.name = name;
    }

    public int getId () {
        return this.id;
    }

    public String getName () {
        return this.name;
    }

    public void setId (int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Name: " + this.name;
    }
}
