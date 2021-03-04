package src.ua.com.alevel;

import src.ua.com.alevel.test.Test;
import src.ua.com.alevel.test.Factorial;


public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.run();
        Factorial factorial = new Factorial();
        factorial.factorial(10);
        }
}