package controller;

import lombok.SneakyThrows;
import task3.Graphs;
import task3.GraphsReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphController {
    GraphsReader graphsReader = new GraphsReader();
    Graphs graphs = new Graphs();
    List<String[]> result = graphsReader.initialStartEnd();
    List<Integer> list = new ArrayList<>();

    @SneakyThrows
    public void run() {
        for (String[] s : result) {
            list.add(graphs.dijkstra(graphsReader.cities.indexOf(s[0]) + 1, graphsReader.cities.indexOf(s[1]) + 1, graphsReader.matrix));
        }
        Collections.reverse(list);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            for (Integer i : list) {
                writer.write(String.valueOf(i));
                writer.write('\n');
                System.out.println("The result was recorded into file");
            }
        }
        System.out.println("Choose another logic");
    }


}

