package Animal;

public class Elephant implements Animal {
    @Override
    public void eat() {
        System.out.println("Elefante comendo.");
    }

    @Override
    public void sleep() {
        System.out.println("Elefante dormindo.");
    }
}
