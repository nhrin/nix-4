package alevel.controller;

import alevel.listener.DbConfig;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class ConsoleManager {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Long userId;
    Long acId;
    String username;
    String password;

    @SneakyThrows
    public void reg() {

        System.out.println("Enter user id");
        this.userId = Long.valueOf(reader.readLine());
        System.out.println("Enter account id");
        this.acId = Long.valueOf(reader.readLine());
        System.out.println("Enter username for database");
        this.username = reader.readLine();
        System.out.println("Enter password for database");
        this.password = reader.readLine();
        DbConfig.configure(username, password);
    }

    @SneakyThrows
    public void run() {
        System.out.println("It's a module 3");
        System.out.println("Choose mode:");
        System.out.println("1 - add new operation");
        System.out.println("2 - export account statement");
        System.out.println("enter \"1\" or \"2\". Enter \"0\" for exit...");
        String position;
        while ((position = reader.readLine()) != null) {
            switch (position) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Choose type of operation:");
                    System.out.println("1 - income operation");
                    System.out.println("2 - expense operation");
                    String type = reader.readLine();
                    System.out.println("Enter amount");
                    String amount = reader.readLine();
                    if (type.equals("1")) {
                        System.out.println("Enter category");
                        Controller.showIncomeCategories(username, password);
                        String category = reader.readLine();
                        Controller.addIncomeOperation(Long.valueOf(amount), category, username, password, userId, acId);
                        run();
                    } else if (type.equals("2")) {
                        System.out.println("Enter category");
                        Controller.showExpenseCategories(username, password);
                        String category = reader.readLine();
                        Controller.addExpenseOperation(Long.valueOf(amount), category, username, password, userId, acId);
                        run();
                    } else {
                        System.out.println("Wrong entering. Try again...");
                        run();
                    }
                    break;
                case "2":
                    System.out.println("Enter date \"from\"");
                    System.out.print("year: ");
                    int year = Integer.valueOf(reader.readLine());
                    System.out.print("month (enter integer): ");
                    int month = Integer.valueOf(reader.readLine());
                    System.out.print("day of month: ");
                    int day = Integer.valueOf(reader.readLine());
                    LocalDate from = LocalDate.of(year, month, day);
                    System.out.println("Enter date \"to\"");
                    System.out.print("year: ");
                    int yearTo = Integer.valueOf(reader.readLine());
                    System.out.print("month (enter integer): ");
                    int monthTo = Integer.valueOf(reader.readLine());
                    System.out.print("day of month: ");
                    int dayTo = Integer.valueOf(reader.readLine());
                    LocalDate to = LocalDate.of(yearTo, monthTo, dayTo);
                    Controller.writeCSV(acId, from, to, username, password);
                    run();
                    break;
            }
        }
    }

}
