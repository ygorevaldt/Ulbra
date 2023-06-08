package Flying;

public class Superman implements Flying {
    @Override
    public void takeOf() {
        System.out.println("Superman decolando.");
    }

    @Override
    public void fly() {
        System.out.println("Superman voando.");
    }

    @Override
    public void land() {
        System.out.println("Superman aterrissando.");
    }
}
