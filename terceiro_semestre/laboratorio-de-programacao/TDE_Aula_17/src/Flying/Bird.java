package Flying;

public class Bird implements Flying {
    @Override
    public void takeOf() {
        System.out.println("Passaro decolando.");
    }

    @Override
    public void fly() {
        System.out.println("Passaro voando.");
    }

    @Override
    public void land() {
        System.out.println("Passaro aterrissando.");
    }
}
