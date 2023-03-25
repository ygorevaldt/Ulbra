public class Trapezio {

    private double biggestBase;
    private double lowerBase;
    private double heigth;

    public Trapezio(double biggestBase, double lowerBase, double heigth) {
        this.biggestBase = biggestBase;
        this.lowerBase = lowerBase;
        this.heigth = heigth;
    }

    public double calculateArea() {
        int divisionValue = 2;
        double area = ((this.biggestBase + this.lowerBase)* heigth) / divisionValue;
        return  area;
    }
}
