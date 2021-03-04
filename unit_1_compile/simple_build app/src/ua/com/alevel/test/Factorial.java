package src.ua.com.alevel.test;

import org.apache.commons.math3.util.*;


public class Factorial {

    public void factorial (int n){
        System.out.println("Start factorial of " + n + " calculate");
        System.out.println("Factorial " + n + " = " + ArithmeticUtils.factorial(n));
    }

}
