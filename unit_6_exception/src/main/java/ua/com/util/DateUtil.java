package ua.com.util;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.util.Locale;

public class DateUtil {

    public static Long addDate (Long date, Long forAdding) {
        return date + forAdding;
    }
    public static Long addSec (Long date, Long SecForAdding) {
        return date + SecForAdding * 1000;
    }
    public static Long addMin (Long date, Long MinForAdding) {
        return date + MinForAdding * 60000;
    }
    public static Long addHour (Long date, Long HourForAdding) {
        return date + HourForAdding * 3600000L;
    }
    public static Long addDay (Long date, Long DayForAdding) {
        return date + DayForAdding * 86400000L;
    }
    public static Long addMonth (Long date, Long MonthForAdding) {
        return date + MonthForAdding * 2592000000L;
    }
    public static Long addYear (Long date, Long YearForAdding) {
        return date + YearForAdding * 31536000000L;
    }
    public static Long addCent (Long date, Long CentForAdding) {
        return date + CentForAdding * 3153600000000L;
    }

    @SneakyThrows
    public static Long time (BufferedReader reader) {
        Long time = 0L;
        System.out.println("Would you enter time? Y/N");
        String s = reader.readLine().toLowerCase(Locale.ROOT);
        if (s.equals("y")) {
            System.out.println("Enter hours");
            time += Long.parseLong(reader.readLine()) * 3600000L;
            System.out.println("Enter minutes");
            time += Long.parseLong(reader.readLine()) * 60000;
            System.out.println("Enter seconds");
            time += Long.parseLong(reader.readLine()) * 1000;
            System.out.println("Enter milliseconds");
            time += Long.parseLong(reader.readLine());
        }
        return time;

    }



}
