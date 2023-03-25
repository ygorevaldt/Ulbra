public class Triangulo {
    private double base;
    private double heigth;

    public Triangulo(double base, double heigth) {
        this.base = base;
        this.heigth = heigth;
    }

    public double calculateArea() {
        int divisionValue = 2;
        double area = (this.base * this.heigth) / divisionValue;
        return area;
    }
}
