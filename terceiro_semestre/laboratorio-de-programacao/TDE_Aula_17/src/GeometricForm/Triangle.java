package GeometricForm;

public class Triangle implements GeometricForm {
    double Base;
    double Height;
    double Hide1;
    double Hide2;
    double Hide3;
    int DivisionValueToCalculateArea = 2;

    public Triangle(double base, double height, double hide1, double hide2, double hide3) {
        this.Base = base;
        this.Height = height;
        this.Hide1 = hide1;
        this.Hide2 = hide2;
        this.Hide3 = hide3;
    }

    @Override
    public double calculateArea() {
        return (this.Base * this.Height) / this.DivisionValueToCalculateArea;
    }
    @Override
    public double calculatePerimeter() {
        return this.Hide1 + this.Hide2 + this.Hide3;
    }
    @Override
    public void showResults(String figureName) {
        System.out.println("Area " + figureName + ": " + this.df.format(this.calculateArea()));
        System.out.println("Perímetro " + figureName + ": " + this.df.format(this.calculatePerimeter()));
    }
}
