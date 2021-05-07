package ua.com.alevel.controller;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainController {

    AuthorController authorController = new AuthorController();
    BookController bookController = new BookController();


    @SneakyThrows
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose operation with whom do you want use (1 - author; 2 - book)");
        String position;
        while ((position = reader.readLine()) != null) {
            switch (position) {
                case "0" : {
                    System.exit(0);
                }
                case "1" : authorController.run();
                break;
                case "2" : bookController.run();
                break;
            }
            System.out.println("Your variant: if you want exit, please input 0, else, repeat logic");
        }
        reader.close();
    }
}
