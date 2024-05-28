package org.practice.collection;

public class CustomQueue {
    protected int[] data;
    int end=0;
    private static final int DEFAULT_SIZE=10;

    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {

        this.data=new int[size];
    }
    public boolean isEmpty(){
        return end==0; //ptr original value only then data[] can be empty
    }
    public boolean isFull() {
        return end==data.length; //ptr is at last index
    }
    public boolean insert(int item){
        if (isFull()){
            return false;
        }
        data[end++]=item;
        return true;
    }
    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }
        int removed=data[0];
        //shift the elements to the left
        for (int i = 1; i <end ; i++) {
            data[i-1]=data[i];
        }
        end--;
        return removed;
    }
    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Queue is empty!");
        }
        return data[0];
    }
    public void display(){
        for (int i = 0; i <end; i++) {
            System.out.println(data[i]+" ");
        }
        System.out.println("END");
    }
}
