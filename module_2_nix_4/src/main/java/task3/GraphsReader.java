package task3;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GraphsReader {
    static String path = "input.txt";
    static List<String> inputData = read();
    static Integer size = Integer.parseInt(inputData.get(0));
    public static List cities = initialCities();
    static List<String[]> result = initialStartEnd();
    public static int[][] matrix = new int[size + 1][size + 1];

    static int start[];
    static int end[];

    public GraphsReader() {
        initialMatrix();
    }

    private static void initialMatrix() {

        int tempForCity = 1;

        for (int i = 1; i < inputData.size(); i++) {
            if (inputData.get(i).equals(cities.get(tempForCity - 1))) {
                Integer countNeighbors = Integer.parseInt(inputData.get(i + 1));
                for (int j = 0; j < countNeighbors; j++) {
                    matrix[tempForCity][Integer.parseInt(inputData.get(i + 2 + j).substring(0, 1))] = Integer.parseInt(inputData.get(i + 2 + j).substring(2));

                }
                tempForCity++;
            }

            if (tempForCity == size) {
                break;
            }

        }
    }


    public static List initialStartEnd() {
        List<String[]> list = new ArrayList<>();
        for (int i = inputData.size() - 1; i > 0; i--) {
            if (!inputData.get(i).matches(".*\\d+.*")) {
                list.add(inputData.get(i).split(" "));
            } else {
                break;
            }
        }
        return list;
    }


    private static List initialCities() {
        List<String> init = new ArrayList<>();
        int j = 0;
        for (int i = 1; j < size; i++) {
            init.add(inputData.get(i));
            i = i + Integer.parseInt(inputData.get(i + 1)) + 1;
            j++;
        }
        return init;
    }

    @SneakyThrows
    private static List<String> read() {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = reader.readLine()) != null) {
                data.add(s);
            }
        }
        return data;
    }
}
