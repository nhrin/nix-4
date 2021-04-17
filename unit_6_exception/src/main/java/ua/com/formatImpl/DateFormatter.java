package ua.com.formatImpl;

import ua.com.exeption.InvalidFormatException;
import ua.com.util.MonthDayDefinition;
import ua.com.interfaces.Formatter;
import ua.com.interfaces.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DateFormatter implements Formatter, Parser {
    public static String PATTERN_1 = "dd/MM/yyyy";
    public static String PATTERN_2 = "MM/dd/yyyy";
    public static String PATTERN_3 = "MMM-dd-yyyy";
    public static String PATTERN_4 = "dd-MMM-yyyy";

    private static final Map<String, Parser> parsers = Map.of(
            PATTERN_1, DateFormatter::parse1,
            PATTERN_2, DateFormatter::parse2,
            PATTERN_3, DateFormatter::parse3,
            PATTERN_4, DateFormatter::parse4
    );

    private static final Map<String, Formatter> formatters = Map.of(
            PATTERN_1, DateFormatter::format1,
            PATTERN_2, DateFormatter::format2,
            PATTERN_3, DateFormatter::format3,
            PATTERN_4, DateFormatter::format4
    );

    private final Parser parser;
    private final Formatter formatter;

    private DateFormatter(Parser parser, Formatter formatter) {
        this.parser = parser;
        this.formatter = formatter;
    }

    public static DateFormatter ofPattern(String pattern) {
        final Parser parser = Optional.ofNullable(parsers.get(pattern))
                .orElseThrow(InvalidFormatException::new);
        final Formatter formatter = Optional.ofNullable(formatters.get(pattern))
                .orElseThrow(InvalidFormatException::new);
        return new DateFormatter(parser, formatter);
    }

    public Long parse(String val) {
        return parser.parse(val);
    }

    public String format(Long val) {
        return formatter.format(val);
    }

    private static Long parse1(String val) {
        Long mlSecsInDay = 86400000L;
        Long mlSecsInYear = mlSecsInDay * 365;

        final List<Long> collect = Arrays.stream(val.split("/"))
                .map(Long::valueOf)
                .collect(Collectors.toList());

        return (collect.get(0) - 1) * mlSecsInDay + MonthDayDefinition.countDays(collect.get(1), collect.get(2)) + (collect.get(2) - 1) * mlSecsInYear;
    }

    private static Long parse2(String val) {
        Long mlSecsInDay = 86400000L;
        Long mlSecsInYear = mlSecsInDay * 365;
        final List<Long> collect = Arrays.stream(val.split("/"))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        return (collect.get(1) - 1) * mlSecsInDay + MonthDayDefinition.countDays(collect.get(0), collect.get(2)) + (collect.get(2) - 1) * mlSecsInYear;
    }

    private static Long parse3(String val) {
        Long mlSecsInDay = 86400000L;
        Long mlSecsInYear = mlSecsInDay * 365;
        final List<String> collect = Arrays.stream(val.split("-"))
                .map(String::valueOf)
                .collect(Collectors.toList());
        return (MonthDayDefinition.countDays(MonthDayDefinition.monthNumber(collect.get(0)), Long.parseLong(collect.get(2))) + (Long.parseLong(collect.get(1)) - 1) * mlSecsInDay + (Long.parseLong(collect.get(2)) - 1) * mlSecsInYear);

    }

    private static Long parse4(String val) {
        Long mlSecsInDay = 86400000L;
        Long mlSecsInYear = mlSecsInDay * 365;
        final List<String> collect = Arrays.stream(val.split("-"))
                .map(String::valueOf)
                .collect(Collectors.toList());
        return (MonthDayDefinition.countDays(MonthDayDefinition.monthNumber(collect.get(1)), Long.parseLong(collect.get(2))) + (Long.parseLong(collect.get(0)) - 1) * mlSecsInDay + (Long.parseLong(collect.get(2)) - 1) * mlSecsInYear);

    }

    private static String format1(Long val) {
        Long secondsTotal = val / 1000;
        Long daysTotal = secondsTotal / 86400;
        Long yearsTotal = daysTotal / 365;
        int daysWithoutYears = (int) (daysTotal - yearsTotal * 365);
        int months = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[0];
        int days = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[1];
        Long hoursTotal = val / 3600000;
        Long hours = (val - (daysTotal * 86400000)) / 3600000;
        Long minutes = (val - hoursTotal * 3600000) / 60000;
        Long minutesTotal = secondsTotal / 60;
        Long seconds = (val - minutesTotal * 60000) / 1000;
        Long mlSeconds = val - secondsTotal * 1000;
        String res = (days) + "/" + (months) + "/" + (yearsTotal + 1) + " time "
                + hours + "h:" + minutes + "m:" + seconds + "s:" + mlSeconds + "mls";
        return res;
    }

    private static String format2(Long val) {
        Long secondsTotal = val / 1000;
        Long daysTotal = secondsTotal / 86400;
        Long yearsTotal = daysTotal / 365;
        int daysWithoutYears = (int) (daysTotal - yearsTotal * 365);
        int months = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[0];
        int days = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[1];
        Long hoursTotal = val / 3600000;
        Long hours = (val - (daysTotal * 86400000)) / 3600000;
        Long minutes = (val - hoursTotal * 3600000) / 60000;
        Long minutesTotal = secondsTotal / 60;
        Long seconds = (val - minutesTotal * 60000) / 1000;
        Long mlSeconds = val - secondsTotal * 1000;
        String res = (months) + "/" + (days) + "/" + (yearsTotal + 1) + " time "
                + hours + "h:" + minutes + "m:" + seconds + "s:" + mlSeconds + "mls";
        return res;
    }

    private static String format3(Long val) {
        Long secondsTotal = val / 1000;
        Long daysTotal = secondsTotal / 86400;
        Long yearsTotal = daysTotal / 365;
        int daysWithoutYears = (int) (daysTotal - yearsTotal * 365);
        int months = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[0];
        int days = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[1];
        Long hoursTotal = val / 3600000;
        Long hours = (val - (daysTotal * 86400000)) / 3600000;
        Long minutes = (val - hoursTotal * 3600000) / 60000;
        Long minutesTotal = secondsTotal / 60;
        Long seconds = (val - minutesTotal * 60000) / 1000;
        Long mlSeconds = val - secondsTotal * 1000;
        String res = MonthDayDefinition.monthName(months) + "-" + (days) + "-" + (yearsTotal + 1) + " time "
                + hours + "h:" + minutes + "m:" + seconds + "s:" + mlSeconds + "mls";
        return res;
    }

    private static String format4(Long val) {
        Long secondsTotal = val / 1000;
        Long daysTotal = secondsTotal / 86400;
        Long yearsTotal = daysTotal / 365;
        int daysWithoutYears = (int) (daysTotal - yearsTotal * 365);
        int months = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[0];
        int days = MonthDayDefinition.countMonthAndDays(daysWithoutYears, yearsTotal)[1];
        Long hoursTotal = val / 3600000;
        Long hours = (val - (daysTotal * 86400000)) / 3600000;
        Long minutes = (val - hoursTotal * 3600000) / 60000;
        Long minutesTotal = secondsTotal / 60;
        Long seconds = (val - minutesTotal * 60000) / 1000;
        Long mlSeconds = val - secondsTotal * 1000;
        String res = (days) + "-" + MonthDayDefinition.monthName(months) + "-" + (yearsTotal + 1) + " time "
                + hours + "h:" + minutes + "m:" + seconds + "s:" + mlSeconds + "mls";
        return res;
    }

}

