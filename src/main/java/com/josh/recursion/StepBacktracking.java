package com.josh.recursion;

import java.util.ArrayList;
import java.util.List;

public class StepBacktracking {
    public static void main(String[] args) {

        List<List<Integer>> combos = countStepCombos(30);

        for (List<Integer> combo : combos) {
            System.out.println(combo);
        }
    }

    private static List<List<Integer>> countStepCombos(int steps) {
        List<List<Integer>> combos =  new ArrayList<>();
        countStepsHelper(steps, 0, new ArrayList<>(), combos);

        return combos;
    }

    private static void countStepsHelper(int numSteps, int stepsSoFar, List<Integer> stepsTaken, List<List<Integer>> combos) {
        if (numSteps == stepsSoFar) {
            combos.add(new ArrayList<>(stepsTaken));
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (stepsSoFar + i <= numSteps) {
                stepsTaken.add(i);
                countStepsHelper(numSteps, stepsSoFar + i, stepsTaken, combos);
                stepsTaken.remove(stepsTaken.size() - 1);
            }
        }
    }
}
