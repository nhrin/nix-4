package service;

import level1.impl.UniqSymbols;
import level1.impl.UniqSymbolsOfArrayImpl;

import java.util.Scanner;

public class ChoiseAndRunTask {






    static Scanner scanner = new Scanner(System.in);
    public static void choicer() {
        System.out.println("Please, choose the level (you may enter 1, 2 or 3)");
        int choiceLevel = scanner.nextInt();
        switch (choiceLevel) {
            case 1:
                System.out.println("Please, choose the task:");
                System.out.println("Enter 1 for use \"Uniq symbols\"");
                System.out.println("Enter 2 for use \"IsPossibleKnightsMove\"");
                System.out.println("Enter 3 for use \"Area of triangle\"");
                int choiceTaskeOfLevel1 = scanner.nextInt();
                switch (choiceTaskeOfLevel1) {
                    case 1:
                        UniqSymbolsService.run();
                        break;
                    case 2:
                        IsPossibleKnightsMoveService.run();
                        break;
                    case 3:
                        AreaOfTriangleService.run();
                        break;

                }
                break;
            case 2:
                System.out.println("This level has only one task - Correct sequence of brackets");
                CorrectSequenceService.run();
                break;
            case 3:
                System.out.println("This level has only one task - Game of life");
                GameOfLifeService.run();
                break;



        }

    }

}

