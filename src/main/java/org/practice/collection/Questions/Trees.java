package org.practice.collection.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees {
    private class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        private int getValue(){
            return value;
        }
        public Node(int value){
            this.value=value;
        }

    }
    private Node root;
    public Trees(){}
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public void display(){
        display(this.root,"Root node: ");
    }
//    public Node display(){
//
//    }
    private void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + node.value);
        System.out.println("And height: "+ node.height);
        display(node.left, "Left child of "+ node.value +":");
        display(node.right, "Right child of "+ node.value+":");

    }
    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node != null) {
            return node;
        }
        if (node == null) {
            return new Node(value);
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
    public void populate(int[] nums){
        if(this.root!=null){
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }}
    }
    //height of the tree, level counter
    public List<List<Integer>> levelOrder(Node node){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(queue.isEmpty()){
            int levelSize= queue.size();
            List<Integer> current=new ArrayList<>();
            for (int i = 0; i <levelSize ; i++) {
                Node currentNode=queue.poll();
                current.add(currentNode.value);
                if (currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if (currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(current);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={10,1,4,6,7,9,8,5};
        Trees tree=new Trees();
        System.out.println();
        tree.insert(7);
        tree.display();
        tree.populate(nums);
        tree.display();
        Trees t=new Trees();
        t.insert(10);

        t.insert(12);

        t.insert(2);

        t.insert(20);

        t.insert(1);

        t.display();



      //  tree.levelOrder();



    }
}
