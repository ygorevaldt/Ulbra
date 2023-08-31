public class Motor {
    private double potency = 0.0;

    public Motor(double potency) {
        this.potency = potency;
    }

    public void power() {
        System.out.println("Motor ligado");
    }

    public void powerOff() {
        System.out.println("Motor desligado");
    }

    public double getPotency() {
        return potency;
    }
}
