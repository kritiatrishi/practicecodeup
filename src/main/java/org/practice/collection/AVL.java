package org.practice.collection;

import java.util.logging.SocketHandler;

public class AVL {

        public class Node {
            private int value;
            private int height;
            private org.practice.collection.AVL.Node left;
            private org.practice.collection.AVL.Node right;

            private Node(int value) {
                this.value = value;
            }

            public int getValue() {
                return value;
            }

        }

        private org.practice.collection.AVL.Node root;

        public AVL() {
        }

        public int height(org.practice.collection.AVL.Node node) {
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

        private void display(org.practice.collection.AVL.Node node, String details) {
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

        private org.practice.collection.AVL.Node insert(int value, org.practice.collection.AVL.Node node) {
            if (node == null) {
                return node = new org.practice.collection.AVL.Node(value);
            }
            if (value < node.getValue()) {
                return node.left = insert(value, node.left);
            }
            if (value > node.getValue()) {
                return node.right = insert(value, node.right);
            }
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            return rotate(node);
        }
        private Node rotate(Node node){
            if(height(node.left)-height(node.right)>1){
                //left heavy case
                if(height(node.left.left)-height(node.left.right)>0){
                    //left left case
                    return rotateRight(node);
                }
                if(height(node.left.left)-height(node.left.right)<0){
                    //left right case
                    node.left=rotateLeft(node.left);
                    return rotateRight(node);
                }
            }
            if(height(node.left)-height(node.right)<-1){
                //right heavy case
                if(height(node.right.left)-height(node.right.right)<0){
                    //right right case
                    return rotateLeft(node);
                }
                if(height(node.right.left)-height(node.right.right)>0){
                    //left right case
                    node.right=rotateRight(node.right);
                    return rotateLeft(node);
                }
            }
        return node;
        }
        private Node rotateLeft(Node p){
            Node c=p.right;
            Node t=c.left;
            c.left=p;
            p.right=t;
            p.height=Math.max(height(p.left),height(p.right)+1);
            c.height=Math.max(height(c.left),height(c.right)+1);
            return c;
        }
        private Node rotateRight(Node p){
            Node c=p.left;
            Node t=c.right;
            c.right=p;
            p.left=t;
            p.height=Math.max(height(p.left),height(p.right)+1);
            c.height=Math.max(height(c.left),height(c.right)+1);
            return c;
        }

    public boolean balanced() {
            return balanced(root);
        }

        private boolean balanced(org.practice.collection.AVL.Node node) {
            if (node == null) {
                return true;
            }
            return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
        }
        public void populatedSorted(int[] nums){
            populatedSorted(nums,0,nums.length);
        }
        private void populatedSorted(int[] nums,int start,int end){
            if(start>=end){
                return;
            }
            int mid=start+(end-start)/2;
            this.insert(nums[mid]);
            populatedSorted(nums,start,mid);
            populatedSorted(nums,mid+1,end);
        }
        public void populate(int[] nums){
            for (int i = 0; i < nums.length; i++) {
                this.insert(nums[i]);
            }
        }
        public static void main(String[] args) {
            AVL tree=new AVL();
            int[] a={5,2,1,9,7,10,3,6};
            int[] b={1,2,3,4,5,6,7,8};
            for(int i=0;i<1000;i++){
                tree.insert(i);
            }
            System.out.println(tree.height(tree.root));
          //  tree.populate(a);
          //  tree.display();
         //   tree.populatedSorted(b);
            tree.display();
        }

}
