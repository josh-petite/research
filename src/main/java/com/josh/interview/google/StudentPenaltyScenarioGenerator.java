package com.josh.interview.google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentPenaltyScenarioGenerator {

    // https://leetcode.com/discuss/interview-question/130159/Google-onsite-interview-question/
    /*
    * There is student attendance information that has 3 state.

    O: attendance
    L: late
    A: absent

    If student is "absent two days in total" OR "late three days in a row", student get penalty.

    Example
    There are 8 ways that student get penalty in 3 days.

    LLL   AAO   AOA   OAA   AAL
    ALA   LAA   AAA
    * */

    public static void main(String[] args) {
        int numDays = 7;

        List<String> penaltyScenarios = generatePenaltyScenarios(numDays);
        System.out.println("Number of Days: " + numDays);

        List<String> filteredPenalties = penaltyScenarios
                .stream()
                .filter(p -> has(p, 2, "A") || p.contains("LLL"))
                .collect(Collectors.toList());

        System.out.println("Count: " + filteredPenalties.size());
        filteredPenalties.forEach(a -> System.out.println(String.format("%s", a)));
    }

    private static boolean has(String source, int count, String target) {
        int found = 0;

        for (int i = 0; i < source.length(); i++) {
            if (source.substring(i, i + 1).equals(target)) {
                found++;
            }
        }

        return found >= count;
    }

    private static List<String> generatePenaltyScenarios(int numDays) {
        List<String> results = new ArrayList<>();

        String pool = "OLA";
        genHelper("", pool, numDays, results);

        return results;
    }

    private static void genHelper(String prefix, String pool, int numDays, List<String> results) {
        if (prefix.length() == numDays) {
            results.add(prefix);
            return;
        }

        for (int i = 0; i < pool.length(); i++) {
            genHelper(prefix + pool.substring(i, i + 1), pool, numDays, results);
        }
    }
}
