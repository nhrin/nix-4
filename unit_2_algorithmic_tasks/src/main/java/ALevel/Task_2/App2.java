package ALevel.Task_2;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * Calculate numbers of each letter from random string
 */

public class App2 {
    public static void main(String[] args) {

        System.out.println(symbolsMy(args[0]));

    }

    private static Map<Character, Integer> symbolsMy(String input) {
        String s = input.replaceAll("[^A-Za-zА-Яа-я]", ""); // separate letters only
        char[] arr = s.toCharArray();
        Character[] arrRes = ArrayUtils.toObject(arr); // change type of array to object with apache.commons

        Map<Character, Integer> res = new TreeMap<>();

        for (Character c : arrRes) {

            if (!res.containsKey(c)) {
                res.put(c, 1);
            } else {

                res.put(c, res.get(c) + 1);
            }
        }

        return res;

    }

}
