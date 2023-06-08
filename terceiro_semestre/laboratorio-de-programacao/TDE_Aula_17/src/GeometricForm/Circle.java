package GeometricForm;

public class Circle implements GeometricForm {
    private double Ray;

    public Circle(double ray) {
        this.Ray = ray;
    }

    @Override
    public double calculateArea() {
        int valueToElevateRay = 2;
        return Math.PI * Math.pow(this.Ray, valueToElevateRay);
    }

    @Override
    public double calculatePerimeter() {
        int multiplier = 2;
        return multiplier * Math.PI * this.Ray;
    }

    @Override
    public void showResults(String figureName) {
        System.out.println("Area " + figureName + ": " + this.df.format(this.calculateArea()));
        System.out.println("Perímetro " + figureName + ": " + this.df.format(this.calculatePerimeter()));
    }

}
