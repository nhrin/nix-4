package ua.com.alevel;

import ua.com.alevel.controller.AuthorController;
import ua.com.alevel.controller.MainController;

public class CrudConsoleMain {
    public static void main(String[] args) {
        System.out.println("Hello");
        MainController mainController = new MainController();
        mainController.run();
    }
}
