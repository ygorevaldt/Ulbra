package com.ygorevaldt.calculatev2.calculate.filter;

import com.ygorevaldt.calculatev2.calculate.basic.operators.Operator;

public abstract class Filter {
    public abstract Operator getOperator(String operator);
}
