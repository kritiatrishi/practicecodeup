package org.practice.collection.Questions;

import java.util.Stack;

public class QueueUsingStacksRemoveEfficient {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public boolean isEmpty(){
        return first.isEmpty();
    }
    public void add(int item){
        while(!first.isEmpty()){
        second.push(first.pop());
        }
        first.push(item);
        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }
    public int remove(){
       return first.pop();}
    public int peek(){
      return first.peek();
    }
}
