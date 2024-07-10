package org.practice.collection;

import java.util.ArrayList;

public class Heaps<T extends Comparable<T>>{

    private ArrayList<T> list;
    public Heaps(){
        list=new ArrayList<>();

    }
    private void swap(int first,int second){
        T temp=list.get(first);
        list.set(first,list.get(second));
        list.set(second,temp);
    }
    private int parent(int index){
        return (index-1)/2;
    }
    private int left(int index){
        return index*2+1;
    }
    private int right(int index){
        return index*2+2;
    }
    private void upheap(int index){
        if(index==0){
            return;
        }
        int p=parent(index);
        if(list.get(index).compareTo(list.get(p))<0){
            swap(index,p);
            upheap(p);
        }
    }
    public void insert(T value){
        list.add(value);   //insert at last first then compare with all parents to up heap
        upheap(list.size()-1);
    }
    public T remove() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Removing from an empty heap!");
        }
        T temp=list.get(0);
        T last=list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0,last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int index) {
        int min=index;
        int left=left(index);
        int right=right(index);
        if(left<list.size()&&list.get(min).compareTo(list.get(left))>0){
            min=left;
        }
        if(right<list.size()&&list.get(min).compareTo(list.get(right))>0){
            min=right;
        }
        if(min!=index){
            swap(min,index);
            downheap(min);
        }
    }
    public ArrayList<T> heapSort() throws Exception{
        ArrayList<T> data=new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }

    public static void main(String[] args) throws Exception{
        String name="kriti";
        String nam="krit";
        System.out.println(name.hashCode());
        System.out.println("---------------------------");
        System.out.println(nam.hashCode());
        System.out.println("---------------------------");
        Heaps<Integer> heap=new Heaps<>();
        heap.insert(10);
        heap.insert(22);
        heap.insert(40);
        heap.insert(2);
        heap.insert(60);
        // System.out.println(heap.remove());
       ArrayList list=heap.heapSort();
       System.out.println(list);
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());

    }
}

