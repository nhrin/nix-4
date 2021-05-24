package util;

public class Graphs {
    private static int max = 100000;

    public static int dijkstra(int start, int end, int[][] matrix) {
        int lastValue;
        int[][] costs = new int[matrix.length][matrix.length];
        for (int i = 0; i <= end; i++) {
            for (int j = 0; j <= end; j++) {
                costs[i][j] = -1;
                if (i >= start && j == start) {
                    costs[i][j] = 0;
                }
                if (i == start && j > start) {
                    costs[i][j] = max;
                }
            }
        }

        int countI = start + 1;
        int countJ = start + 1;
        lastValue = costs[start][start];

        while (needToContinue(start, end, costs)) {
            int min = 0;
            int minI = 0;
            int minJ = 0;

            for (int j = countJ; j <= end; j++) {
                if (costs[countI][j] <= 0) {
                    if (matrix[countI - 1][j] == 0) {
                        costs[countI][j] = max;
                    } else {
                        costs[countI][j] = matrix[countI - 1][j] + lastValue;
                    }
                    if (j == countJ || min > costs[countI][j]) {
                        min = costs[countI][j];
                        minI = countI;
                        minJ = j;
                    }
                }
            }
            lastValue = min;
            for (int a = minI + 1; a <= end; a++) {
                costs[a][minJ] = min;
            }
            countI++;
            countJ++;
        }
        return costs[end][end];
    }

    private static boolean needToContinue(int start, int end, int[][] weight) {
        for (int i = start; i <= end; i++) {
            for (int j = start; j < end + 1; j++) {
                if (weight[i][j] < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
