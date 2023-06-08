package Animal;

public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Gato comendo.");
    }

    @Override
    public void sleep() {
        System.out.println("Gato dormindo.");
    }
}
