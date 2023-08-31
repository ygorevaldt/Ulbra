package com.ygorevaldt.calculatev2.calculate.resource;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Double> numbers = new ArrayList<>();

    public void includeNumber () {
        if (this.numbers.size() == 2) {
            return;
        }

        System.out.println("Número: ");
        double number = this.scanner.nextDouble();
        this.scanner.nextLine();
        this.numbers.add(number);
    }

    public ArrayList<Double> getNumbers () {
        return this.numbers;
    }

    public String getOperator () {
        System.out.println("Operador: ");
        return this.scanner.nextLine();
    }

}
