package com.josh.interview.facebook;

import java.util.HashMap;
import java.util.Map;

public class OneEditAway {
    /*
    *  Write a function to return if two words are exactly "one edit" away, where an edit is:

       - Inserting one character anywhere in the word (including at the beginning and end)
       - Removing one character
       - Replacing exactly one character
    * */

    public static void main(String[] args) throws Exception {

        isOneEditAway("left", "rightttt");
        isOneEditAway("start", "tart");
        isOneEditAway("start", "slept");

        isOneEditAway("market", "marker");

        isOneEditAway(null, "tart");
    }

    private static void isOneEditAway(String left, String right) {
        // null check
        if (left == null || right == null) {
            System.out.println("null input not allowed!");
            return;
        }

        if (Math.abs(left.length() - right.length()) > 1) {
            System.out.printf("Values differ too much: %s, %s%n", left, right);
            return;
        }

        HashMap<Character, Integer> leftMap = generateFrequencyMap(left);
        HashMap<Character, Integer> rightMap = generateFrequencyMap(right);

        int lDiff = 0, rDiff = 0;

        for (Map.Entry<Character, Integer> e : leftMap.entrySet()) {

            if (rightMap.containsKey(e.getKey())) {
                rDiff += rightMap.get(e.getKey()) - e.getValue();
            } else {
                lDiff += e.getValue();
            }
        }

        if (lDiff <= 1 && rDiff <= 1) {
            System.out.printf("%s is one edit away from %s!%n", left, right);
        } else {
            System.out.printf("%s is NOT one edit away from %s!%n", left, right);
        }
    }

    private static HashMap<Character, Integer> generateFrequencyMap(String value) {
        return value.chars()
                .mapToObj(c -> (char) c)
                .collect(HashMap::new,
                        (map, str) -> {
                            if (!map.containsKey(str)) {
                                map.put(str, 1);
                            } else {
                                map.put(str, map.get(str) + 1);
                            }
                        },
                        HashMap::putAll);
    }
}
