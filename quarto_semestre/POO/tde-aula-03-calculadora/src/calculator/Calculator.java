package calculator;
import calculator.operators.Operator;

abstract class Calculator {
    abstract void start();
    protected abstract double getNumber();
    protected abstract Operator getOperator();
}
