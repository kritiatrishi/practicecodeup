package org.practice;

public class BoxWeight extends Box{
    int weight;
    public BoxWeight(){
        this.weight=-1;
    }
    public BoxWeight(BoxWeight other) {
        super(other.l, other.h, other.w);
        this.weight = weight;
    }
    public BoxWeight(int l, int h, int w, int weight) {
        super(l, h, w);// calls the parent class constructor
        this.weight = weight;
    }
    public BoxWeight(int side, int weight) {
        super(side);// calls the parent class constructor
        this.weight = weight;
    }
}

