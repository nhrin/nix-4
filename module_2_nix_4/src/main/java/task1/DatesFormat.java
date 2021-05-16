package task1;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DatesFormat {

    public static List<String> result(List<String> data) {
        List<String> res = new ArrayList<>();

        for (String s : data) {
           try {
               res.add(reFormat(s));
           } catch (DateTimeException e) {
               res.add(e.getMessage());
               continue;
           }
        }

        return res;
    }




    private static String reFormat(String arg) {
        final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        final Map<Pattern, DateTimeFormatter> map = Map.of(
                Pattern.compile("\\d{4}/\\d{2}/\\d{2}"), DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                Pattern.compile("\\d{2}/\\d{2}/\\d{4}"), DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                Pattern.compile("\\d{2}-\\d{2}-\\d{4}"), DateTimeFormatter.ofPattern("MM-dd-yyyy")
        );

        return map.keySet()
                .stream()
                .filter(pattern -> pattern.matcher(arg).matches())
                .map(map::get)
                .map(formatter -> formatter.parse(arg))
                .map(outputFormatter::format)
                .findFirst()
                .orElse("ignored");
    }
}
