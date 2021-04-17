package ua.com.service;

import lombok.SneakyThrows;
import ua.com.exeption.InvalidFormatException;
import ua.com.formatImpl.DateFormatter;
import ua.com.util.DateUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DateService {
    final static DateFormatter dateFormatter1 = DateFormatter.ofPattern("dd/MM/yyyy");
    final static DateFormatter dateFormatter2 = DateFormatter.ofPattern("MM/dd/yyyy");
    final static DateFormatter dateFormatter3 = DateFormatter.ofPattern("MMM-dd-yyyy");
    final static DateFormatter dateFormatter4 = DateFormatter.ofPattern("dd-MMM-yyyy");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final static List<Long> dates = new ArrayList<>();

    @SneakyThrows
    public DateService() {
        chooserOutOnScreen();
        String s = reader.readLine();
        System.out.println("Enter date");
        String firstDate = reader.readLine();
        dates.add(chooser(s).parse(firstDate) + DateUtil.time(reader));
    }
@SneakyThrows
    public void run() throws IOException {
        System.out.println("What would you do next?");
        System.out.println("1 - Show sorted dates");
        System.out.println("2 - Ad centuries, years, month (30 days), day, hours, minutes, seconds or milliseconds");
        System.out.println("3 - enter date yet");
        System.out.println("0 - exit app.");

        String position;

        while ((position = reader.readLine()) != null) {


            switch (position) {
                case "0": {
                    System.exit(0);
                }
                case "1": {
                    chooserOutOnScreen();
                    showListDates(chooser(reader.readLine()));
                    run();
                    break;
                }
                case "2": {
                    System.out.println("What wold you add?");
                    System.out.println("1 - century");
                    System.out.println("2 - year");
                    System.out.println("3 - month (30 days)");
                    System.out.println("4 - day");
                    System.out.println("5 - hour");
                    System.out.println("6 - minutes");
                    System.out.println("7 - seconds");
                    System.out.println("8 - milliseconds");
                    String choiceForAdding = reader.readLine();
                    addOpers(choiceForAdding);
                    run();
                    break;
                } case "3" : {
                    addDate(reader);
                    run();
                    break;
                }

            }
        }
        reader.close();
    }

    public static void showListDates(DateFormatter dateFormatter) {
        dates.sort(Long::compareTo);
        for (int i = 1; i <= dates.size(); i++) {
            System.out.println(i + " - " + dateFormatter.format(dates.get(i - 1)));
        }
    }

    private static void chooserOutOnScreen() {
        System.out.println("Please, choose a format");
        System.out.println("1 - dd/MM/yyyy");
        System.out.println("2 - MM/dd/yyyy");
        System.out.println("3 - MMM-dd-yyyy");
        System.out.println("4 - dd-MMM-yyyy");
    }

    private static DateFormatter chooser(String s) {
        switch (s) {
            case "1":
                return dateFormatter1;
            case "2":
                return dateFormatter2;
            case "3":
                return dateFormatter3;
            case "4":
                return dateFormatter4;
        }
        throw new InvalidFormatException();

    }

    @SneakyThrows
    private static void addOpers(String s) {
        switch (s) {
            case "1": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter century count");
                Long cent = Long.parseLong(reader.readLine());
                Long res = DateUtil.addCent(date, cent);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
            case "2": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter years count");
                Long year = Long.parseLong(reader.readLine());
                Long res = DateUtil.addYear(date, year);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
            case "3": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter months count");
                Long year = Long.parseLong(reader.readLine());
                Long res = DateUtil.addMonth(date, year);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
            case "4": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter days count");
                Long day = Long.parseLong(reader.readLine());
                Long res = DateUtil.addDay(date, day);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
            case "5": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter hours count");
                Long hours = Long.parseLong(reader.readLine());
                Long res = DateUtil.addHour(date, hours);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
            case "6": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter minutes count");
                Long mins = Long.parseLong(reader.readLine());
                Long res = DateUtil.addMin(date, mins);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
            case "7": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter seconds count");
                Long secs = Long.parseLong(reader.readLine());
                Long res = DateUtil.addSec(date, secs);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
            case "8": {
                System.out.println("Choose the date for operation");
                showListDates(dateFormatter4);
                Integer choiceDate = Integer.parseInt(reader.readLine()) - 1;
                Long date = dates.get(choiceDate);
                System.out.println("Enter milliseconds count");
                Long mlsecs = Long.parseLong(reader.readLine());
                Long res = DateUtil.addDate(date, mlsecs);
                dates.set(choiceDate, res);
                chooserOutOnScreen();
                System.out.println("Your result - " + chooser(reader.readLine()).format(res));
                System.out.println("************************************************************");
                break;
            }
        }

    }
    @SneakyThrows
    private static void addDate (BufferedReader reader) {
        chooserOutOnScreen();
        String s = reader.readLine();
        System.out.println("Enter date");
        String firstDate = reader.readLine();
        Long time = DateUtil.time(reader);
        dates.add(chooser(s).parse(firstDate) + time);
    }

}
