package org.practice.concepts;
//method overloading--compile time polymorphism
public class Numbers {
    //order differentiation
    void order(String a, int b){

    }
    void order(int b, String a){

    }
    int sum(int a,int b){
        return a+b;
    }
    //signature of method should be different or the order

    int sum(int a,int b,int c){
        return a+b+c;
    }
}

