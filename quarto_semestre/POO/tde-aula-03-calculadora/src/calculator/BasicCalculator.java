package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import calculator.operators.Division;
import calculator.operators.Multiplication;
import calculator.operators.Operator;
import calculator.operators.Subtraction;
import calculator.operators.Sum;

public class BasicCalculator extends Calculator {
    private double result = 0.0; 
    private ArrayList<String> typeOperators = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "="));
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        this.getStarted();
        while (true) {
            double number1 = this.resultIsGreaterThanZero() ? this.result : this.getNumber();
            Operator operator = this.getOperator();

            if (operator == null) {
                this.showResult(this.result);
                break;
            }

            double number2 = this.getNumber();
            ArrayList<Double> numbers = new ArrayList<>(Arrays.asList(number1, number2));
            this.result = this.calculate(numbers, operator);
            System.out.println(this.result);
        }
    }

    private boolean resultIsGreaterThanZero () {
        return this.result > 0.0;
    }

    private void getStarted() {
        System.out.println("Calculadora iniciada");
    }

    protected double getNumber() {
        double number = 0.0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Número: ");
            try {
                number = this.scanner.nextDouble();
                this.scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                this.scanner.nextLine();
            }
        }
        return number;
    }

    protected Operator getOperator() {
        System.out.println("Operador: ");
        String input = this.scanner.nextLine();

        boolean validOperator = this.checkInputedOperator(input);
        while (!validOperator) {
            System.out.println("Operador inválido, digite novamente: ");
            input = this.scanner.nextLine();
            validOperator = this.checkInputedOperator(input);
        }

        if (input.equals("+")) {
            return new Sum();
        }
        if (input.equals("-")) {
            return new Subtraction();
        }
        if (input.equals("*")) {
            return new Multiplication();
        }
        if (input.equals("/")) {
            return new Division();
        }

        return null;
    }

    private void showResult (double value) {
        System.out.println("Resultado: " + value);
    }

    private boolean checkInputedOperator(String input) {
        for (String type : this.typeOperators) {
            if (input.equals(type)) {
                return true;
            }
        }
        return false;
    }

    protected double calculate(ArrayList<Double> numbers, Operator operator) {
        double result = 0.0;
        switch (operator.getType()) {
            case "+":
                result = operator.calculate(numbers);
                break;
            case "-":
                result = operator.calculate(numbers);
                break;
            case "*":
                result = operator.calculate(numbers);
                break;
            case "/":
                result = operator.calculate(numbers);
                break;
            default:
                System.out.println("Erro");
                break;
        }
        return result;
    }
}
