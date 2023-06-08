package Charge;

public class Batery implements Chargeable, Dischargeable {
    @Override
    public void charge() {
        System.out.println("Carregando bateria");
    }
}
