package org.practice.collection.Questions;

import org.practice.Main;
import org.practice.collection.BinaryTree;

import java.util.*;

public class BT {
    private class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }
    private Node root;
    private int diameter=0;
    public BT() {
    }

    private Node insert(int value, Node node){
        if(node!=null){

            return node;
        }
        if(node==null){
            System.out.println("null 1");
        node=new Node(value);
        return node;
    }
        if(value<node.value){
            System.out.println("left 1");
            return node.left=insert(value,node.left);
        }
        if(value>node.value){
            System.out.println("right 1");
            return node.right=insert(value,node.right);
        }
        return node;
    }
    public void insert(int value){
       this.root=insert(value,this.root);
    }
    private void display(Node node){
        while(node==null){
          return;
        }
        System.out.println("Root:"+node.value+"->");
        display(node.left);
        display(node.right);
    }
    public void display(){
        display(this.root);

    }
    public void prettyDisplay(){
        prettyDisplay(this.root, 0);

    }

    private void prettyDisplay(Node node, int level) {
        if(node==null){
            return;
        }
        prettyDisplay(node.right, level+1);
        if(level!=0){
            for (int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.println("|-------->"+node.value);
        }else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left, level+1);

    }
    //--------------------------------------------------------------------------------------------------
    //--------------------------Depth First Search------------------------------------------------------
    // Preorder postorder inorder

    public int diameterOfBinaryTree(){
        int d=diameterOfBinaryTree(root);
        return d;
    }
    private int diameterOfBinaryTree(Node node){

        height(node);
        return diameter;
    }
    public int height(Node node){
        if(node==null){
            return 0;
        }
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        int dia=leftHeight+rightHeight+1;
        diameter= Math.max(dia,diameter);
        return Math.max(leftHeight,rightHeight)+1;
    }
    private Node insertSorted (int[] arr, Node node){
     for(int i=0;i<arr.length;i++){
         if(node!=null){
             System.out.println(node.value);
            return node;
        }
        if(node==null){
            System.out.println(node.value);
            return new Node(arr[i]);
        }
         System.out.println(node.value);
     }
     System.out.println(node.value);
     return node;
    }
    public void insertSorted(int[] arr){
        this.root=insertSorted(arr,this.root);
    }

    //--------------------------------------------------------------------------------------------------
    //--------------------------Breadth First Search------------------------------------------------------
    // Queue/Deque
    public void bfs(){
        System.out.println(bfs(this.root));
    }
    private String bfs(Node node){
        String str="";
        if(node==null){
            return str+"Empty tree";
        }

        Queue<Node> q=new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int levelSize= q.size();
            List<Integer> currentLevel=new ArrayList<>(levelSize);
            for (int i = 0; i <levelSize ; i++) {
                Node current = q.poll();
                currentLevel.add(current.value);
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
                str=str+currentLevel.get(levelSize);
            }

        return str;
        }
        public List<List<Integer>> zigzagLevelOrder(Node node){
            List<List<Integer>> result=new ArrayList<>();
            if(node==null){
                return result;
            }
            Deque<Node> deque=new LinkedList<>();
            deque.offer(node);
            boolean reverse=false;
            while(!deque.isEmpty()){
                int levelSize=deque.size();
                List<Integer> currentLevel=new ArrayList<>(deque.size());
                for(int i=0;i<levelSize;i++){
                    if(!reverse){
                        Node current=deque.pollLast();
                        currentLevel.add(current.value);
                        if(current.left!=null){
                            deque.offerFirst(current.left);
                        }
                        if(current.right!=null){
                            deque.offerFirst(current.right);
                        }
                    }
                    else{
                        Node current=deque.pollFirst();
                        currentLevel.add(current.value);
                        if(current.right!=null){
                            deque.offerLast(current.right);
                        }
                        if(current.left!=null){
                            deque.offerLast(current.left);
                        }

                    }
                    reverse=!reverse;
                }
                result.add(currentLevel);

            }
            return result;
        }
        public Node findSuccessor(Node node,int key){

            if(node==null){
                return null;
            }

            Queue<Node> q=new LinkedList<>();
            q.offer(node);
            while(!q.isEmpty()){
                    Node current = q.poll();
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
            if(current.value==key){
                break;}
            }

            return q.peek();
        }
        public List<Double> averageOfLevels(Node node){
            List<Double> result=new ArrayList<>();
            if(node==null){
                return result;
            }

            Queue<Node> q=new LinkedList<>();
            q.offer(node);
            while(!q.isEmpty()){
                int levelSize= q.size();
               double average=0;
                for (int i = 0; i <levelSize ; i++) {
                    Node current = q.poll();
                    average+= current.value;
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }

                }
                average=average/levelSize;
                result.add(average);
            }

            return result;
        }

        public void insert(int[] num){
         if(this.root!=null){
             System.out.println("null insert arr");
             for (int i = 0; i < num.length; i++) {
                 System.out.println("arr inside");
                 this.insert(num[i]);
             }
         }
        }




    public static void main(String[] args) {
        BT b=new BT();
        b.bfs();
        b.insert(1);
        b.insert(2);
        int[] arr={2,3,4,5,6,7,8};
          b.insert(arr);
          b.prettyDisplay();
          int d=b.diameterOfBinaryTree();
        System.out.println("Diameter: "+d);
        b.insertSorted(arr);
//        b.insert(2);
//        b.insert(3);
//        //b.display();
//        b.insert(4);
//        b.insert(5);
//        b.prettyDisplay();
//        b.bfs();
    }
}
