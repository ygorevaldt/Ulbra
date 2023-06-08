package Person;

public class Athlete implements Runner, Walker {
    @Override
    public void walk() {
        System.out.println("Atleta andando.");
    }

    @Override
    public void run() {
        System.out.println("Atleta correndo.");
    }
}
