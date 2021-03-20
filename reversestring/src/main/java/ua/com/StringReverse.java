package ua.com;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringReverse {

    public static String reverse(String src) {
        final String[] words = src.split(" ");
        return Arrays.stream(words)
                .map(StringReverse::hardReverse)
                .collect(Collectors.joining(" "));
    }

    public static String reverse(String src, String dest) {
        final int length = dest.length();
        int i = 0;
        while (true) {
            int index = src.indexOf(dest, i);
            if (index < 0) {  // 
                break;
            }
            i = index + length;
            src = reverse(src, index, index + length - 1);
        }

        return src;
    }

    public static String reverse(String src, int firstIndex, int lastIndex) {
        final String start = src.substring(0, firstIndex);
        final String end = src.substring(lastIndex + 1);
        return start +
                reverse(src.substring(firstIndex, lastIndex + 1)) +
                end;
    }

    private static String hardReverse(String src) {             // for reverse whole string
        final StringBuilder builder = new StringBuilder();
        char[] chars = src.toCharArray();
        for (int i = chars.length - 1; i > -1 ; i--) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
