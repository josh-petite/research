package com.josh.graphs.tries;

import java.util.ArrayList;
import java.util.List;

public class TrieGraph {
    private TrieNode root;
    private int stackCounter;

    public TrieGraph(TrieNode root) {
        this.root = root;
    }

    public TrieNode getRoot() {
        return root;
    }

    public List<String> getWordsThatStartWith(String input) {
        this.stackCounter = 0;
        List<String> words = new ArrayList<>();

        getWordsThatStartWithInputHelper(root, "", input, words);
        System.out.println("Stack count: " + this.stackCounter);
        System.out.println();

        return words;
    }

    private void getWordsThatStartWithInputHelper(TrieNode current, String word, String input, List<String> words) {
        this.stackCounter++;

        if (input.equals("")) {
            for (TrieNode child : current.getChildren()) {
                String childLetter = child.getData();
                if (childLetter.equals("*")) {
                    words.add(word);
                    continue;
                }

                getWordsThatStartWithInputHelper(child, word + childLetter, input, words);
            }
        } else {
            String currentLetter = input.substring(0, 1);
            current = current.getChildByLetter(currentLetter);

            if (current != null) {
                getWordsThatStartWithInputHelper(current, word + currentLetter, input.substring(1), words);
            }
        }
    }
}
