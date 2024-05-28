package org.practice.collection;

public class CL {
    public CL(Node head, Node tail) {
        this.head = null;
        this.tail = null;
    }
    public CL(){

    }
    public void insert(int val){
        Node node=new Node(val);
        if (head==null){
            head=node;
            tail=node;
            return;
        }
        tail.next=node;
        node.next=head;
        tail=node;

    }


    private Node head;
    private Node tail;

    public void display(){
        Node node=head;
        if(head!=null){
            do {
                System.out.print(node.val+" -> ");
                node=node.next;
            } while(node!=head);
        }
        System.out.print("HEAD");
    }
    public void delete(int value){
        Node node=head;
        if(node==null){
            return;
        }
        if(node.val==value){
            head=head.next;
            tail=head;
            return;
        }
        do {
            Node n=node.next;
            if(n.val==value){
                node.next=n.next;
                break;
            }
            node=node.next;

        }while (node!=head);
    }

    private class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
