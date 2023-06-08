package Animal;

public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Cachorro comendo.");
    }

    @Override
    public void sleep() {
        System.out.println("Cachorro dormindo.");
    }
}
