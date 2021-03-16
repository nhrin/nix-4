package ua.com.alevel.service;

import java.math.BigInteger;

public interface Calculator {

    BigInteger sum(BigInteger a, BigInteger b);
    BigInteger sub(BigInteger a, BigInteger b);
    BigInteger div(BigInteger a, BigInteger b);
    BigInteger mult(BigInteger a, BigInteger b);
}
