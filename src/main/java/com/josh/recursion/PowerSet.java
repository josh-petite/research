package com.josh.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {
    public static void main(String[] args) {

        Set<String> set = new HashSet<String>() {{ add("a"); add("b"); add("c"); }};

        Set<Set<String>> powerSet = makePowerSet(new ArrayList<>(set));
        System.out.println(powerSet);
    }

    private static Set<Set<String>> makePowerSet(List<String> set) {
        Set<Set<String>> powerSet = new HashSet<>();

        if (set.size() == 0) {
            powerSet.add(new HashSet<>());
            return powerSet;
        }

        List<String> list = new ArrayList<>(set);
        String head = list.get(0);
        List<String> rest = new ArrayList<>(list.subList(1, list.size()));

        for (Set<String> current : makePowerSet(rest)) {
            Set<String> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(current);

            powerSet.add(current);
            powerSet.add(newSet);
            System.out.println(String.format("H(%s), C(%s), N(%s) \nPower set: %s\n", head, current, newSet, powerSet));
        }

        return powerSet;
    }
}
