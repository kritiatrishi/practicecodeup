package org.practice.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class NewArrayList<T> {
    private Object[] data;
    private static int DEFAULT_SIZE=10;
    private int size=0;//also working as index value

    public NewArrayList() {
        this.data = new Object[DEFAULT_SIZE];
    }
    public void add(T num){
        if(isFull())
        {
            resize();
        }
        data[size++]=num;
    }

    private boolean isFull() {
        return size== data.length;
    }

    private void resize() {
        Object[] temp=new Object[data.length*2];
        //copy the current items in the new array
        for(int i=0;i< data.length;i++ ){
             temp[i]=data[i];
        }
        data=temp;
    }
    public T remove(){
        T removed=(T)(data[--size]);
        return removed;
    }
    public T get(int index){
        return (T)data[index];
    }
    public int size(){
        return size;
    }
    public void set(int index, T value){
        data[index]=value;
    }
    @Override
    public String toString(){
        return "NewArrayList{"+
                " data="+ Arrays.toString(data)+
                ", size="+size+
                '}';
    }
    public static void main(String[] args) {
        ArrayList listed=new ArrayList();
        listed.add("dbehbdf");
        listed.add(1);
        listed.add(12.34);
        NewArrayList<Integer> list=new NewArrayList();
        list.add(3);
        list.add(6);
        list.add(8);
        System.out.println(list);
    }
}
