package org.practice;

public class BoxPrice extends BoxWeight{
int cost;
BoxPrice(){
    super();
    this.cost=-1;
}
    public BoxPrice(int side,int weight, int cost){
    super(side,weight);
    this.cost=cost;
    }
    public BoxPrice(BoxPrice old){
    super(old);
    this.cost = old.cost;
    }
}

