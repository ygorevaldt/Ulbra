package calculator.operators;

import java.util.ArrayList;

public class Sum extends Operator {
    protected String type = "+";

    public double calculate (ArrayList<Double> numbers) {
        return numbers.get(0) + numbers.get(1);
    };

    public String getType () {
        return this.type;
    };
    
}
