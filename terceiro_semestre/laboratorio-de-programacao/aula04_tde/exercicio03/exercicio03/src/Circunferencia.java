public class Circunferencia {
    private double ray;
    private double PI = 3.14;

    public Circunferencia(double ray) {
        this.ray = ray;
    }

    public double calculateArea() {
        double area = this.PI * (ray * ray);
        return area;
    }

}
