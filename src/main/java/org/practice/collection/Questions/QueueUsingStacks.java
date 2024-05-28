package org.practice.collection.Questions;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;
    public boolean isEmpty(){
        return first.isEmpty();
    }
    public void add(int item){
        first.push(item);
    }
    public int remove(){
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int removed= second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }
    public int peek(){
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int peeked= second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peeked;
    }
}
