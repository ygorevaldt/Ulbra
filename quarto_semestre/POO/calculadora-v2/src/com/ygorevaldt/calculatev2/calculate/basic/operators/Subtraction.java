package com.ygorevaldt.calculatev2.calculate.basic.operators;

import java.util.ArrayList;

public class Subtraction implements Operator {
    @Override
    public double calculate(ArrayList<Double> numbers) {
        return numbers.get(0) - numbers.get(1);
    }
}
