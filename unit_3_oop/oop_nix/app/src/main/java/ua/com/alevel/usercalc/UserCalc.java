package ua.com.alevel.usercalc;

import ua.com.alevel.service.Calculator;
import ua.com.alevel.service.impl.CalculatorImpl;
import ua.com.alevel.service.impl.ConsoleHelperImpl;

import java.math.BigInteger;

public class UserCalc {

    BigInteger res;

    public void run() {
        Calculator calculator = new CalculatorImpl();
        ConsoleHelperImpl consoleHelper = new ConsoleHelperImpl();
        consoleHelper.printCalculator();
        switch (consoleHelper.getArithmOper()) {                  // swith for choose arithmetic operation
            case "+":
                 res = calculator.sum(consoleHelper.getFirstNumber(), consoleHelper.getSecondNumber());
                break;
            case "-":
                res = calculator.sub(consoleHelper.getFirstNumber(), consoleHelper.getSecondNumber());
                break;
            case "/":
                res = calculator.div(consoleHelper.getFirstNumber(), consoleHelper.getSecondNumber());
                break;
            case "*":
                res = calculator.mult(consoleHelper.getFirstNumber(), consoleHelper.getSecondNumber());
                break;
        }
        System.out.println(res);
    }
}
