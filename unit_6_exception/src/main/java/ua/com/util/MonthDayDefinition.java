package ua.com.util;

import ua.com.exeption.InvalidFormatException;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;



public class MonthDayDefinition {
    static final Map<Long, String> months = new HashMap<Long, String>() {{

        put(1L, "JAN");
        put(2L, "FEB");
        put(3L, "MAR");
        put(4L, "APR");
        put(5L, "MAY");
        put(6L, "JUN");
        put(7L, "JUL");
        put(8L, "AUG");
        put(9L, "SEP");
        put(10L, "OCT");
        put(11L, "NOV");
        put(12L, "DEC");

    }};

   public static int[] countMonthAndDays(int days, Long year) {

        boolean isLeapYear = (year + 1) % 4 == 0;
        int[] res = new int[2];

        if (isLeapYear) {

            if (days >= 0 && days < 31) {
                res[0] = 1;
                if (days == 0) {
                    res[1] = 1;
                } else
                    res[1] = days + 1;
            } else if (days >= 31 && days < 60) {
                res[0] = 2;
                res[1] = days - 31 + 1;
            } else if (days >= 60 && days < 91) {
                res[0] = 3;
                res[1] = days - 60 + 1;
            } else if (days >= 91 && days < 121) {
                res[0] = 4;
                res[1] = days - 91 + 1;
            } else if (days >= 121 && days < 151) {
                res[0] = 5;
                res[1] = days - 121 + 1;
            } else if (days >= 151 && days < 182) {
                res[0] = 6;
                res[1] = days - 151 + 1;
            } else if (days >= 182 && days < 213) {
                res[0] = 7;
                res[1] = days - 182 + 1;
            } else if (days >= 213 && days < 244) {
                res[0] = 8;
                res[1] = days - 213 + 1;
            } else if (days >= 244 && days < 274) {
                res[0] = 9;
                res[1] = days - 244 + 1;
            } else if (days >= 274 && days < 305) {
                res[0] = 10;
                res[1] = days - 274 + 1;
            } else if (days >= 305 && days < 335) {
                res[0] = 11;
                res[1] = days - 305 + 1;
            } else if (days >= 335 && days < 366) {
                res[0] = 12;
                res[1] = days - 335 + 1;
            }

        } else {
            if (days >= 0 && days < 31) {
                res[0] = 1;
                if (days == 0) {
                    res[1] = 1;
                } else
                    res[1] = days + 1;
            } else if (days > 31 && days < 59) {
                res[0] = 2;
                res[1] = days - 31 + 1;
            } else if (days > 59 && days < 90) {
                res[0] = 3;
                res[1] = days - 59 + 1;
            } else if (days > 90 && days < 120) {
                res[0] = 4;
                res[1] = days - 90 + 1;
            } else if (days > 120 && days < 150) {
                res[0] = 5;
                res[1] = days - 120 + 1;
            } else if (days > 150 && days < 181) {
                res[0] = 6;
                res[1] = days - 150 + 1;
            } else if (days > 181 && days < 212) {
                res[0] = 7;
                res[1] = days - 181 + 1;
            } else if (days > 212 && days < 243) {
                res[0] = 8;
                res[1] = days - 212 + 1;
            } else if (days > 243 && days < 273) {
                res[0] = 9;
                res[1] = days - 243 + 1;
            } else if (days > 273 && days < 304) {
                res[0] = 10;
                res[1] = days - 273 + 1;
            } else if (days > 304 && days < 334) {
                res[0] = 11;
                res[1] = days - 304 + 1;
            } else if (days > 334 && days < 365) {
                res[0] = 12;
                res[1] = days - 334 + 1;
            }

        }


        return res;
    }


    public static Long countDays(Long month, Long year) {
        boolean isLeapYear = year % 4 == 0;

        if (!isLeapYear) {

            if (month == 2) {
                return 86400000L * 31;
            } else if (month == 3) {
                return 86400000L * 59;
            } else if (month == 4) {
                return 86400000L * 90;
            } else if (month == 5) {
                return 86400000L * 120;
            } else if (month == 6) {
                return 86400000L * 151;
            } else if (month == 7) {
                return 86400000L * 181;
            } else if (month == 8) {
                return 86400000L * 212;
            } else if (month == 9) {
                return 86400000L * 243;
            } else if (month == 10) {
                return 86400000L * 273;
            } else if (month == 11) {
                return 86400000L * 304;
            } else if (month == 12) {
                return 86400000L * 334;
            } else if (month == 1) {
                return 0L;
            }
            return 0L;
        } else {
            if (month == 2) {
                return 86400000L * 31;
            } else if (month == 3) {
                return 86400000L * 60;
            } else if (month == 4) {
                return 86400000L * 91;
            } else if (month == 5) {
                return 86400000L * 121;
            } else if (month == 6) {
                return 86400000L * 152;
            } else if (month == 7) {
                return 86400000L * 182;
            } else if (month == 8) {
                return 86400000L * 213;
            } else if (month == 9) {
                return 86400000L * 244;
            } else if (month == 10) {
                return 86400000L * 274;
            } else if (month == 11) {
                return 86400000L * 305;
            } else if (month == 12) {
                return 86400000L * 335;
            } else if (month == 1) {
                return 0L;
            }
            return 0L;
        }
    }


    public static String monthName(int month) {
        return months.get((long) month);
    }

    public static Long monthNumber(String name) {
        for (Map.Entry<Long, String> entry : months.entrySet()) {
            if (entry.getValue().equals(name.toUpperCase(Locale.ROOT))) return entry.getKey();
        }
        throw new InvalidFormatException();
    }
}
