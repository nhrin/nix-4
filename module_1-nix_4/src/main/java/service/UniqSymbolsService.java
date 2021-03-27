package service;

import level1.impl.UniqSymbols;
import level1.impl.UniqSymbolsOfArrayImpl;

import java.util.Scanner;

public class UniqSymbolsService {
    static Scanner scanner = new Scanner(System.in);


    static void run () {
        System.out.println("Enter length of your array");
        int [] arr = new int[scanner.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter number");
            arr[i] = scanner.nextInt();
        }
        UniqSymbols uniqSymbols = new UniqSymbolsOfArrayImpl();

        System.out.println("There are " + uniqSymbols.uniqSymbols(arr) + " uniq in your array");
        scanner.close();
    }
}
