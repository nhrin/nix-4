package controller;

import lombok.SneakyThrows;
import task1.DatesFormat;
import task1.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import task1.*;
public class ControllerDates {

    private static void usingDefList() {
        Test test = new Test();

        System.out.println("Default list:");
        System.out.println();

        for (String s : test.dates) {
            System.out.println(s);
        }

        System.out.println("Result:");
        System.out.println();

        List<String> res = DatesFormat.result(test.dates);
        for (String s : res) {
            System.out.println(s);
        }
        System.out.println("Enter \"up\" for choose another task");
    }



    @SneakyThrows
    private static void manuallyEntering(BufferedReader reader) {
        List<String> temp = new ArrayList<>();
        System.out.println("Enter date");
        String position;
        while (!(position = reader.readLine()).equals("0")) {
            System.out.println("Enter date, if you want to stop enter 0");
            temp.add(position);
        }
        List<String> res = DatesFormat.result(temp);
        for (String s : res) {
            System.out.println(s);
        }
        System.out.println("Enter \"up\" for choose another task");
    }

    @SneakyThrows
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Task 1: Dates parsing");
            System.out.println("How wold you like use program (enter \"1\" or \"2\"):");
            System.out.println("1 - enter dates manually");
            System.out.println("2 - use default list");
            System.out.println("Enter \"up\" for choose another task");
            String position;
            while ((position = reader.readLine()) != null) {
                switch (position) {
                    case "0": {
                        System.exit(0);
                    }
                    case "1":
                        manuallyEntering(reader);
                        break;
                    case "2":
                        usingDefList();
                        break;
                    case "up": {
                        MainController mainController = new MainController();
                        mainController.run();
                        break;
                    }
                }
            }
        }
    }
}




