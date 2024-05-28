
package org.practice.collection;

public class DynamicStack extends CustomStack{
    public DynamicStack() {
        super();   // calls CustomStack()
    }
    public DynamicStack(int size) {
        super(size);  // calls CustomStack(size)
    }
    @Override
    public boolean push(int item){
        if(this.isFull()) {
            //double the array size
            int[] temp = new int[data.length * 2];
            //copy all previous items in new data
            System.arraycopy(data, 0, temp, 0, data.length);
            //for(i<data.length)
            //temp[i]=data[i];
            data=temp;
        }
        return super.push(item);
    }
}
