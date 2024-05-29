package org.practice.collection;

public class BinarySearchTree {
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        private Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    private Node root;

    public BinarySearchTree() {
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of "+ node.value +":");
        display(node.right, "Right child of "+ node.value+":");
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return node = new Node(value);
        }
        if (value < node.getValue()) {
            return node.left = insert(value, node.left);
        }
        if (value > node.getValue()) {
            return node.right = insert(value, node.right);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    public void populate(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }
    public static void main(String[] args) {
    BinarySearchTree tree=new BinarySearchTree();
    int[] a={5,2,1,9,7,10,3,6};
    tree.populate(a);
    tree.display();
    }
}