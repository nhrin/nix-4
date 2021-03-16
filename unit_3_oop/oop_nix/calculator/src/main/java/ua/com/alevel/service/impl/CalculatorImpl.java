package ua.com.alevel.service.impl;

import ua.com.alevel.service.Calculator;

import java.math.BigInteger;

public class CalculatorImpl implements Calculator {
    @Override
    public BigInteger sum(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger sub(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger div(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

    @Override
    public BigInteger mult(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }
}
