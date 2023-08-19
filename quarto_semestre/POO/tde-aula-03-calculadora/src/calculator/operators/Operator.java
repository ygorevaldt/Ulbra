package calculator.operators;

import java.util.ArrayList;

public abstract class Operator {
    protected String type;
    public abstract double calculate (ArrayList<Double> numbers);
    public abstract String getType();
}
