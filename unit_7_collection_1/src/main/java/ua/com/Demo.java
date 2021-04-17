package ua.com;

import java.util.List;

public class Demo {
    static List<String> strings = new OrderedList<>();

    public static void main(String[] args) {
        strings.add("111");
        strings.add("222");
        strings.add("222");

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
