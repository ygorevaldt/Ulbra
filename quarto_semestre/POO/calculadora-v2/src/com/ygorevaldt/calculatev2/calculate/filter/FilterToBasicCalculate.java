package com.ygorevaldt.calculatev2.calculate.filter;

import com.ygorevaldt.calculatev2.calculate.basic.operators.*;

public class FilterToBasicCalculate extends Filter {

    @Override
    public Operator getOperator (String operator) {
        if (operator.equals("+")) {
            return new Sum();
        }
        if (operator.equals("-")) {
            return new Subtraction();
        }
        if (operator.equals("*")) {
            return new Multiplication();
        }
        if (operator.equals("/")) {
            return new Division();
        }

        return null;
    }
}
