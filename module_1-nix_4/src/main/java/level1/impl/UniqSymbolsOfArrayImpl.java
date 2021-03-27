package level1.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqSymbolsOfArrayImpl implements level1.impl.UniqSymbols {

    static Set<Integer> set = new HashSet<>();

    @Override
    public int uniqSymbols(int[] arr) {
        Arrays.stream(arr).forEach(i -> set.add(i) );
        return set.size();
    }
}
