package controller;

import lombok.SneakyThrows;
import task2.FindFirstUniqueName;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NamesController {
    private final String path = "names.txt";

    @SneakyThrows
    public void run() {

        System.out.println("It`s a second task - NAMES");

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            List<String> names = new ArrayList<>();
            String s;
            while ((s = reader.readLine()) != null) {
                names.add(s);
            }
            System.out.println("First unique name in the list:");
            System.out.println(FindFirstUniqueName.findUniqueName(names));
        }
    }
}


