import com.ygorevaldt.calculatev2.calculate.basic.BasicCalculate;
import com.ygorevaldt.calculatev2.calculate.basic.operators.Operator;
import com.ygorevaldt.calculatev2.calculate.filter.FilterToBasicCalculate;
import com.ygorevaldt.calculatev2.calculate.resource.Input;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BasicCalculate basicCalculate = new BasicCalculate();
        Input input = new Input();
        FilterToBasicCalculate filterToBasicCalculate = new FilterToBasicCalculate();

        input.includeNumber();
        Operator operator = filterToBasicCalculate.getOperator(input.getOperator());
        input.includeNumber();

        ArrayList<Double> numbers = input.getNumbers();

        String result = String.format("Resultado: %.2f", basicCalculate.executeOperation(operator, numbers));
        System.out.println(result);

    }
}