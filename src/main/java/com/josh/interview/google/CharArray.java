package com.josh.interview.google;

public class CharArray {
    /*
    *   Given two character arrays which contain only 0 ~ 9 or '<'.
        One '<' cancels out one digit in front of it.
        Determine whether these two character are the same.
        Use only constant space!!

        Example 1:

        charA = {'1','2','3','<','4','<'}
        charB = {'1','2'}
        return true

        Because in charA, 3 is canceled out by its right < and 4 is canceled out by its right <.
        Therefore, charA becomes {'1','2'}, which is the same as charB.

        Example 2:

        charA = {'1','2','3','<','4','<','5'}
        charB = {'1','2'}
        return false

        Because charA becomes {'1','2','5'}

        Example 3:

        charA = {'1','2','3','<','<','<','4','<','5'}
        charB = {'1','2','<','8','<','<','5','5','<'}
        return true

        Because charA and charB become {'5'}
    *
    * */
    public static void main(String[] args) {
        char[] charA = {'1', '2', '3', '<', '<', '<', '4', '<', '5'};
        char[] charB = {'1', '2', '<', '8', '<', '<', '5', '5', '<'};

        System.out.println("Eval: " + checkEquality(charA, charB));

        System.out.println("Eval: " + checkEquality(
                new char[]{'1', '2', '3', '<', '<', '<', '4', '<', '5', '6'},
                new char[]{'1', '2', '3', '<', '<', '<', '4', '<', '5'}
                )
        );
    }

    private static boolean checkEquality(char[] charA, char[] charB) {
        String a = evaluateInput(new String(charA));
        String b = evaluateInput(new String(charB));

        return a.equals(b);
    }

    private static String evaluateInput(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        int i = input.length() - 1;
        int charsToRemove = 0;

        while (i > 0) {
            String current = input.substring(i, i + 1);
            if (!current.equals("<")) {
                if (charsToRemove == 0) {
                    stringBuilder.append(current);
                } else {
                    charsToRemove--;
                }
            } else {
                charsToRemove++;
            }

            i--;
        }

        return stringBuilder.toString();
    }
}
