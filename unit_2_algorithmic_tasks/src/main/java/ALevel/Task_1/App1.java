package ALevel.Task_1;

import java.util.Arrays;

/**
 * Calculate sum of numbers from random string
 */

public class App1 {

    public static void main(String[] args) {

        System.out.println(calculateSum(args[0]));

    }

    private static int calculateSum(String input) {
        String[] arr = input.split("\\D+"); // separate numbers

        return Arrays.stream(arr)
                .filter(value -> !value.isEmpty())
                .mapToInt(num -> Integer.parseInt(num))
                .sum();
    }

}