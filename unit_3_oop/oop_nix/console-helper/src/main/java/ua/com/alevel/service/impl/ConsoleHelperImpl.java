package ua.com.alevel.service.impl;

import ua.com.alevel.service.ConsoleHelper;

import java.math.BigInteger;
import java.util.Scanner;


public class ConsoleHelperImpl implements ConsoleHelper {

    private static BigInteger firstNumber;
    private static BigInteger secondNumber;
    private static String arithmOper;


    public BigInteger getFirstNumber() {
        return firstNumber;
    }

    public BigInteger getSecondNumber() {
        return secondNumber;
    }

    public String getArithmOper() {
        return arithmOper;
    }

    @Override
    public void printCalculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first integer and press ENTER");

        try {                                                                           // if user enter invalid data
            firstNumber = scanner.nextBigInteger();
        } catch (Exception e) {
           throw new RuntimeException("Enter integer only. Sorry...");
        }

        System.out.println("Enter arithmetic operation (you have to choose from: +, -, *, /)");

        String s = scanner.next();
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") ){             // operation validation
           }else throw new RuntimeException("You enter invalid symbol. Sorry... ");
        arithmOper = s;

        System.out.println("Enter second integer and press ENTER");

        try {                                                                               // if user enter invalid data
            secondNumber = scanner.nextBigInteger();
        } catch (Exception e) {
            throw new RuntimeException("You enter invalid symbol. Sorry... ");
        }

        scanner.close();
    }


}
