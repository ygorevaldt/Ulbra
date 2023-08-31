package calculator;
import java.util.ArrayList;
import java.util.Scanner;

import calculator.operators.Operator;

abstract class Calculator {
    protected double result = 0.0; 
    protected ArrayList<String> typeOperators;
    protected Scanner scanner = new Scanner(System.in);

    abstract void start ();
    protected abstract ArrayList<String> getTypeOperators();
    protected abstract double getNumber();
    protected abstract Operator getOperator();

    protected void getStarted () {
        System.out.println("Calculadora iniciada");
    }

    protected void showResult (double value) {
        System.out.println("Resultado: " + value);
    }

    protected boolean checkInputedOperator (String input) {
        for (String type : this.typeOperators) {
            if (input.equals(type)) {
                return true;
            }
        }
        return false;
    }

    protected boolean resultIsGreaterThanZero () {
        return this.result > 0.0;
    }
}
