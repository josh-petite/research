package com.josh.graphs.tries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TriesTypeahead {
    public static void main(String[] args) throws IOException {
        TrieGraph graph = populateTrieGraph();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (!input.equalsIgnoreCase("q")) {
            System.out.print("> ");
            input = in.readLine();
            printWordsThatStartWith(graph, input);
        }

        in.close();
    }

    private static void printWordsThatStartWith(TrieGraph graph, String input) {
        long start = System.currentTimeMillis();

        List<String> words = graph.getWordsThatStartWith(input);
        words.sort(Comparator.naturalOrder());

        AtomicInteger i = new AtomicInteger(1);
        words.forEach(w -> {
            System.out.println(String.format("%s. %s", i, w));
            i.getAndIncrement();
        });

        System.out.println(String.format("Time elapsed: %sms", (System.currentTimeMillis() - start)));
    }

    private static TrieGraph populateTrieGraph() {

        TrieNode root = new TrieNode();
        TrieGraph graph = new TrieGraph(root);

        InputStream in = TriesTypeahead.class.getClassLoader().getResourceAsStream("words.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String word = reader.readLine();

            while (word != null) {
                int i = 0;
                TrieNode current = root;

                while (i < word.length()) {
                    String currentLetter = word.substring(i, i + 1);
                    current = current.addChild(currentLetter);
                    i++;
                }

                current.addChild("*");

                word = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return graph;
    }
}
