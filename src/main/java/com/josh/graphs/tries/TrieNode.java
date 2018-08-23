package com.josh.graphs.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieNode {
    private String data;
    private HashMap<String, TrieNode> children;

    public TrieNode() {
        this.data = null;
        this.children = new HashMap<>();
    }

    public TrieNode(String data) {
        this.data = data;
        this.children = new HashMap<>();
    }

    public TrieNode addChild(String data) {
        if (children.containsKey(data)) {
            return children.get(data);
        }

        TrieNode tn = new TrieNode(data);
        this.children.put(data, tn);

        return tn;
    }

    public String getData() {
        return data;
    }

    public TrieNode getChildByLetter(String letter) {
        return children.get(letter);
    }

    public List<TrieNode> getChildren() {
        return new ArrayList<>(children.values());
    }
}
