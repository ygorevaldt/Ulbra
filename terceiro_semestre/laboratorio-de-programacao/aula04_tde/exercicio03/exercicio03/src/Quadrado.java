public class Quadrado {

    private double side;

    public Quadrado(double side) {
        this.side = side;
    }
    public double calculateArea() {
        double area = this.side * this.side;
        return area;
    }
}
