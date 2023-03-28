public class Fracao {
    private int numerator;
    private int denominator;

    public Fracao(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fracao multiply(Fracao other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fracao(newNumerator, newDenominator);
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
