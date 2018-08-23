package com.josh.trees;

public class TreeNode {
    Integer data;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
    }

    public TreeNode(Integer data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("Self: %s, Left: %s, Right: %s",
                data, left != null ? left.data : "null", right != null ? right.data : "null");
    }
}
