public abstract class GeometricFigure {

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public abstract void showResults();
}

class Square extends GeometricFigure {
    private double Side;

    public Square(double side) {
        this.Side = side;
    }

    public Square() {
    }

    public void setSide(double side) {
        this.Side = side;
    }

    public double getSide() {
        return this.Side;
    }

    @Override
    public double calculateArea() {
        double area = this.Side * this.Side;
        return area;
    }

    public double calculatePerimeter() {
        double perimeter = this.Side + this.Side + this.Side + this.Side;
        return perimeter;
    }

    public void showResults() {
        System.out.println("A Area do quadrado é: " + this.calculateArea());
        System.out.println("O perímetro do quadrado é: " + this.calculatePerimeter());
    }
}