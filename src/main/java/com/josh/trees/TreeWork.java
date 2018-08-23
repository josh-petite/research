package com.josh.trees;

public class TreeWork {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.printPreOrder();

        tree.printInOrder();

        tree.printPostOrder();

        tree.printLevelOrder();

        System.out.println("4 exists: " + tree.dfs(4));
        System.out.println("12 exists: " + tree.dfs(12));
    }
}
