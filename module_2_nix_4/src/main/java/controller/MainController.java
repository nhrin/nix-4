package controller;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainController {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.run();
    }

    ControllerDates controllerDates = new ControllerDates();
    NamesController namesController = new NamesController();
    GraphController graphController = new GraphController();



    @SneakyThrows
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("It's s module 2.");
            System.out.println("Choose the task (enter \"1\", \"2\" or \"3\"). Enter \"0\" for exit");
            String position;
            while ((position = reader.readLine()) != null) {
                switch (position) {
                    case "1":
                        controllerDates.run();
                        run();
                        break;
                    case "2":
                        namesController.run();
                        run();
                        break;
                    case "3":
                        graphController.run();
                        break;
                    case "0":
                        System.exit(0);
                        run();
                        break;
                }
            }
        }
    }
}
