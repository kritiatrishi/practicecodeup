package org.practice;
//Inheritance
public class Box {
    int l;
    int w;
    int h;
    public Box() {
        this.l=-1;
        this.h=-1;
        this.w=-1;
    }
    Box(int side){
        this.l=side;
        this.h=side;
        this.w=side;
    }
    Box(int l,int h,int w){
        this.l=l;
        this.h=h;
        this.w=w;
    }
    Box(Box old){
        this.l=old.l;
        this.h=old.h;
        this.w=old.w;
    }
    void info(){
        System.out.println("Box is running");
    }
}
