package service;

import level1.impl.IsPossibleKnightsMoveImpl;

import java.util.Scanner;

public class IsPossibleKnightsMoveService {
    static Scanner scanner = new Scanner(System.in);

    static void run () {
        System.out.println("We have an endless chessboard where coordinates are indicated by non-negative numbers");
        System.out.println("Enter start coordinates: ");
        System.out.print("x=");
        int startX = scanner.nextInt();
        System.out.println();
        System.out.print("y=");
        int startY = scanner.nextInt();
        System.out.println("Enter end coordinates: ");
        System.out.print("x=");
        int finX = scanner.nextInt();
        System.out.println();
        System.out.print("y=");
        int finY = scanner.nextInt();
        IsPossibleKnightsMoveImpl isPossibleKnightsMove = new IsPossibleKnightsMoveImpl(startX, startY, finX, finY);
        if (isPossibleKnightsMove.isPossible(Math.abs(startX) - Math.abs(finX), Math.abs(startY) - Math.abs(finY))) {
            System.out.println("Move is possible");
        } else {
            System.out.println("Move is impossible");
        }
        scanner.close();
    }
}
