package level3.impl;

import level3.GameOfLife;

import java.util.Random;

public class GameOfLifeImpl implements GameOfLife {

    @Override
    public int[][] gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;                                // Make second bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;                                // Make second bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j
                 = 0; j < n; j++) {
                board[i][j] >>= 1;                                  // Get second state.
            }
        }
        return board;
    }

    public int[][] randomArr(int a, int b) {

        Random random = new Random();
        int[][] res = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (random.nextBoolean()) {
                    res[i][j] = 1;
                } else {
                    res[i][j] = 0;
                }
            }
        }
        System.out.println("Below you can see random array:");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
        return res;
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;

        return lives;
    }
}
