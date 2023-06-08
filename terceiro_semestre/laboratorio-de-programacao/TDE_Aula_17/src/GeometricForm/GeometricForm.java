package GeometricForm;
import java.text.DecimalFormat;

public interface GeometricForm {
    DecimalFormat df = new DecimalFormat("#.##");
    double calculateArea();
    double calculatePerimeter();
    void showResults(String figureName);
}
