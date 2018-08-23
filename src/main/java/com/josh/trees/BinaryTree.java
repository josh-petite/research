package com.josh.trees;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
    interface PrintOrder {
        void print(TreeNode root);
    }

    private TreeNode root;

    BinaryTree() {
        TreeNode twoNode = new TreeNode(2);
        TreeNode fourNode = new TreeNode(4);
        TreeNode sevenNode = new TreeNode(7);
        TreeNode nineNode = new TreeNode(9);

        TreeNode threeNode = new TreeNode(3, twoNode, fourNode);
        TreeNode eightNode = new TreeNode(8, sevenNode, nineNode);

        this.root = new TreeNode(5, threeNode, eightNode);
    }

    private void printOrderFormatter(String prefix, PrintOrder po) {
        System.out.println(prefix);
        po.print(root);
        System.out.printf("%n%n");
    }

    void printInOrder() {
        printOrderFormatter("In Order:", this::printInOrderInternal);
    }

    private void printInOrderInternal(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrderInternal(root.left);
        System.out.print(root.data + " ");
        printInOrderInternal(root.right);
    }

    void printPreOrder() {
        printOrderFormatter("Pre Order:", (r) -> printPreOrderInternal(root));
    }

    private void printPreOrderInternal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPreOrderInternal(root.left);
        printPreOrderInternal(root.right);
    }

    void printPostOrder() {
        printOrderFormatter("Post Order:", (r) -> printPostOrderInternal(root));
    }

    private void printPostOrderInternal(TreeNode root) {
        if (root == null) {
            return;
        }

        printPostOrderInternal(root.left);
        printPostOrderInternal(root.right);
        System.out.print(root.data + " ");
    }

    void printLevelOrder() {
        printOrderFormatter("Level Order:", this::printLevelOrderInternal);
    }

    private void printLevelOrderInternal(TreeNode root) {
        Queue<TreeNode> nodeStack = new LinkedList<>();
        nodeStack.add(root);

        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.poll();
            if (current == null) {
                continue;
            }

            System.out.print(current.data + " ");
            nodeStack.add(current.left);
            nodeStack.add(current.right);
        }
    }

    boolean dfs(Integer target) {
        return dfsInternal(root, target);
    }

    private boolean dfsInternal(TreeNode root, Integer target) {
        if (root == null) {
            return false;
        }

        if (root.data.equals(target)) {
            return true;
        }

        if (dfsInternal(root.left, target)) {
            return true;
        }

        if (dfsInternal(root.right, target)) {
            return true;
        }

        return false;
    }

    boolean bfs(Integer target) {
        return false;
    }
}
