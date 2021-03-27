package service;

import level2.impl.CorrectSequenceOfBracketsImpl;

import java.util.Scanner;

public class CorrectSequenceService {
    static Scanner scanner = new Scanner(System.in);

    public static void run () {
        System.out.println("Enter your string");
        String s = scanner.nextLine();
        CorrectSequenceOfBracketsImpl sequenceOfBrackets = new CorrectSequenceOfBracketsImpl();
        if (sequenceOfBrackets.isRightSequence(s)) {
            System.out.println("This string is right");
        } else {
            System.out.println("This string is wrong");
        }
    }
}
