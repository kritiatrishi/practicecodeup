package org.practice.collection;

public class LL {

    private Node head;
    private Node tail;
    private int size;
    public LL(){
        this.size=0;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;

        }
        System.out.println("END");
    }
    public void insertRec(int val, int index){
        head=insertRec(val,index,head);
    }
    private Node insertRec(int val, int index, Node node){
        if(index==0){
            Node temp=new Node(val,node);
            size++;
            return temp;
        }
        node.next=insertRec(val,--index,node.next);
        return node;
    }
    public void insertFirst(int val){
        Node node=new Node(val);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }
    public void insertLast(int val){
        if(tail==null){
            insertFirst(val);
            return;
        }
        Node node=new Node(val);
        tail.next=node;
        tail=node;
        size++;

    }
    public void insert(int val,int index){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==size){
            insertLast(val);
            return;
        }
        Node temp=head;
        for (int i = 1; i <index ; i++) {
            temp=temp.next;
        }
        Node node=new Node(val,temp.next);
        temp.next=node;
        size++;
    }
    public int deleteFirst(){
        int val=head.value;
        head=head.next;
    if (head==null) {
        tail = null;
    }
    size--;
    return val;
    }
    public int deleteLast(){
        if(size<=1) {
            return deleteFirst();
        }
        Node secondLast=get(size-2);
        int val= tail.value;
        tail=secondLast;
        tail.next=null;
        return val;
    }
    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
         Node previous=get(index-1);
         int val=previous.next.value;
         previous.next=previous.next.next;

         return val;
    }
    public Node get(int index){
        Node node=head;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    public Node find(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public void duplicates(){
       Node node=head;

       while(node.next!=null){
           if(node.value==node.next.value){
               if(node.next.next==null)
               {
                   break;
               }
               node.next=node.next.next;

               size--;
           }
           else{
               node=node.next;
           }
       }
       tail=node;
       tail.next=null;
    }
    public static LL merge(LL first, LL second){
        Node f= first.head;
        Node s=second.head;
        LL ans=new LL();
        while(f!=null&&s!=null)
        {
            if(f.value<s.value){
                ans.insertLast(f.value);
                f=f.next;
            }
            else{
                ans.insertLast(s.value);
                s=s.next;
            }
        }
        while(f!=null){
            ans.insertLast(f.value);
            f=f.next;
        }
        while(s!=null){
            ans.insertLast(s.value);
            s=s.next;
        }
        return ans;
    }
    public int lengthCycle(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                Node temp=slow;
                int length=0;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=slow);
                return length;
            }
        }
        return 0;
    }
    public Node detectCycle(Node head){
        int length=0;
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                length=lengthCycle(slow);
                break;
            }
        }
        Node f=head;
        Node s=head;
        while(length>0) {
            s = s.next;
            length--;

            while(f!=s){
             f=f.next;
             s=s.next;
            }
            return s;
            }
        return null;
    }
    public boolean isHappy(int n){
        int slow=n;
        int fast=n;
        do {
            slow=findSquare(slow);
            fast=findSquare(findSquare(fast));
        }while(slow!=fast);
        if(slow==1){
            return true;
        }
        return false;
    }

    private int findSquare(int num) {
        int ans=0;
        while(num>0){
            int rem=num%10;
            ans+=rem*rem;
            num/=10;
        }
        return ans;
    }
    public Node middleNode(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public Node sortList(Node head){
        if(head==null||head.next!=null){
            return head;
        }
        Node mid=middleNode(head);
        Node left=sortList(head);
        Node right=sortList(mid);
        return merge(left,right);
    }
    public void reverse(Node node){
        if(node==tail){
            head=tail;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail.next=null;
    }
    public void reverse(){
        if(size<2){
            return;
        }
        Node prev=null;
        Node present=head;
        Node next=present.next;
        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null){
                next=next.next;
            }
            head=prev;
        }
    }
    public Node reverseBetween(Node head, int left, int right){
        if(left==right){
            return head;
        }
        Node current=head;
        Node prev=null;
        for(int i=0;i<left-1&&current!=null;i++){
            prev=current;
            current=current.next;
        }
        Node newEnd=current;
        Node last=prev;
        Node next=current.next;
        for(int i=0;i<right-left+1&&current!=null;i++){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null)
            {
                next=next.next;
            }
        }
        if(last!=null){
            last.next=prev;
        }
        else{
            head=prev;
        }
        newEnd.next=current;
        return head;
    }
    public void bubbleSort(){
        bubbleSort(size-1,0);
    }

    private void bubbleSort(int row, int col) {
        if(row==0){
            return;
        }
        if(col<row) {
            Node first = get(col);
            Node second = get(col + 1);
            if (first.value > second.value) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        }
        else{
            bubbleSort(row-1,0);
        }

    }

    public Node merge(Node list1,Node list2){
    Node dummyHead=new Node();
    Node tail=dummyHead;
    while(list1!=null&&list1.next!=null){
        if(list1.value<list2.value){
            tail.next=list1;
            list1=list1.next;
            tail=tail.next;
        }
        else
        {
            tail.next=list2;
            list2=list2.next;
            tail=tail.next;
        }
    }
    tail.next=(list1!=null)? list1:list2;
    return dummyHead.next;
    }
    public boolean hasCycle(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
//        LL l=new LL();
//        l.insertFirst(9);
//        l.insertFirst(6);
//        l.insertFirst(3);
//        l.insertFirst(1);
//
//        l.insert(1,1);
//        l.insertRec(1,1);
//        l.display();
//        l.duplicates();
//        l.display();

    }

     private class Node{
         private int value;
         private Node next;

         public Node() {
         }

         public Node(int value){
             this.value=value;
         }
         public Node(int value, Node next){
             this.value=value;
             this.next=next;
         }
     }
}
