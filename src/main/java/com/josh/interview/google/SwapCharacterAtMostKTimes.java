package com.josh.interview.google;

public class SwapCharacterAtMostKTimes {
    // https://leetcode.com/discuss/interview-question/124596/Swap-character-at-most-K-times/

    /*
    * Given two string s and t and a positive integer K, determine whether we can swap any two characters in string s at most K times so that s is equal to t.

    Example 1

    s = "converse"
    t = "conserve"
    K = 1

    returns true

    ---

    Example 2

    s = "aabbccdd"
    t = "ddbbccaa"
    K = 1

    returns false

    * */
    public static void main(String[] args) {
        run("converse", "conserve", 1); // true
        run("aabbccdd", "ddbbccaa", 1); // false
        run("magic", "mgaci", 2); // true
        run("magic", "mgaic", 1); // true
        run("magic", "mvaic", 1); // true
    }

    private static void run(String s, String t, int k) {
        boolean swappable = checkIfSwappable(s, t, k);
        System.out.println(String.format("Swappable: %s :: %s, in K times (%s) -- Is it possible? <%s>", s, t, k, swappable));
    }

    private static boolean checkIfSwappable(String s, String t, int k) {
        StringBuilder sDiff = new StringBuilder(), tDiff = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                sDiff.append(s, i, i + 1);
                tDiff.append(t, i, i + 1);
            }
        }

        // times 2 due to one character swap generating two differences
        return sDiff.length() <= k * 2 && sDiff.chars().sum() == tDiff.chars().sum();
    }
}
