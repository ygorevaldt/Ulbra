package Flying;

public class Airplane implements Flying {
    @Override
    public void takeOf() {
        System.out.println("Avião decolando.");
    }
    @Override
    public void fly() {
        System.out.println("Avião voando.");
    }

    @Override
    public void land() {
        System.out.println("Avião aterrissando.");
    }
}
