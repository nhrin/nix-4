package ua.com.alevel;

import au.com.bytecode.opencsv.CSVReader;
import lombok.SneakyThrows;
import ua.com.alevel.controller.AuthorController;
import ua.com.alevel.controller.MainController;

import java.io.FileReader;

public class CrudFilesMain {
@SneakyThrows


    public static void main(String[] args) {
        System.out.println("Hello");
        MainController mainController = new MainController();
        mainController.run();
    }
}
