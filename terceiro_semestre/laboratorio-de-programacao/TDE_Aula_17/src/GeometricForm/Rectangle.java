package GeometricForm;

public class Rectangle implements GeometricForm {
    double Length;
    double Width;
    public Rectangle(double length, double width) {
        this.Length = length;
        this.Width = width;
    }
    @Override
    public double calculateArea() {
        return this.Length * this.Width;
    }

    @Override
    public double calculatePerimeter() {
        return (this.Length + this.Width) * 2;
    }

    public void showResults(String figureName) {
        System.out.println("Area " + figureName + ": " + this.df.format(this.calculateArea()));
        System.out.println("Perímetro " + figureName + ": " + this.df.format(this.calculatePerimeter()));
    }

}
