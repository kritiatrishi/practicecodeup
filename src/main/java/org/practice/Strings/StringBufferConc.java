package org.practice.Strings;

import java.text.DecimalFormat;
import java.util.Arrays;

public class StringBufferConc {
    public static void main(String[] args) {
        //constructor 1
        StringBuffer buffer= new StringBuffer();
        //constructor 2
        StringBuffer buffer1= new StringBuffer("nsdurgbgl");
        //constructor 3
        StringBuffer buffer2= new StringBuffer(30);
        //removing whitespaces
        String s="njn ewknc f    wfnoefn wo";
        System.out.println(s);
        System.out.println(s.replaceAll("\\s",""));
        //split string
        String a="shfd fjjefkei jdwnxsjcn lwfeldi";
        String[] names=a.split(" ");
        System.out.println(Arrays.toString(names));
        //rounding off
        DecimalFormat df=new DecimalFormat("0.000");
        System.out.println(df.format(3.89));
        //adds to the string
        buffer.append("saefwsrhtdh");
        buffer.append("nullllll");
        //insert at index
        buffer.insert(3,"gh123");
        //replace at index start and end--end is not inclusive
        buffer1.replace(1,5,"hate");
        System.out.println(buffer.toString());
        //you can delete from index start and end
        buffer.delete(1,2);
        System.out.println(buffer.toString());
        buffer.reverse();
        //by default 16 you can change by third constructor
        buffer.capacity();

    }

}
