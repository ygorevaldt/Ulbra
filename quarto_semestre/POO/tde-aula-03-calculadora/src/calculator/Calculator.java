package calculator;

import java.util.ArrayList;

import calculator.operators.Operator;

abstract class Calculator {
    abstract void start();
    protected abstract double calculate(ArrayList<Double> numbers, Operator operator);
    protected abstract double getNumber();
    protected abstract Operator getOperator();
}
