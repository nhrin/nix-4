package service;

import level3.impl.GameOfLifeImpl;

import java.util.Scanner;

public class GameOfLifeService {
    static Scanner scanner = new Scanner(System.in);

    public static void run () {
        System.out.println("Enter size of bord: ");
        System.out.print("m=");
        int m = scanner.nextInt();
        System.out.print("n=");
        int n = scanner.nextInt();
        GameOfLifeImpl gameOfLife = new GameOfLifeImpl();
        int res[][] = gameOfLife.gameOfLife(gameOfLife.randomArr(m, n));
        System.out.println("Result:");
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {

                System.out.print(res[i][j]);
            }

        }
    }
}
