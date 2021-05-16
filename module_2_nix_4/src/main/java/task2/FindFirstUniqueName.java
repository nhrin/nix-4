package task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindFirstUniqueName {
    public static String findUniqueName(List<String> data) {
        Set<String> names = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (String s : data) {
            if (names.add(s)) {
                result.add(s);
            } else result.remove(s);
        }
        return result.get(0);
    }
}
