package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

import calculator.operators.Division;
import calculator.operators.Multiplication;
import calculator.operators.Operator;
import calculator.operators.Subtraction;
import calculator.operators.Sum;

public class BasicCalculator extends Calculator {
    public BasicCalculator () {
        this.typeOperators = this.getTypeOperators();
    }

    @Override
    protected ArrayList<String> getTypeOperators () {
        return new ArrayList<>(Arrays.asList("+", "-", "*", "/", "="));
    }

    @Override
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
            operator.calculate(numbers);
            this.result = operator.calculate(numbers);
            System.out.println(this.result);
        }
    }
 
    @Override
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

    @Override
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
}
