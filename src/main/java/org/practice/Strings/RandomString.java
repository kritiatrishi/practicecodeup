package org.practice.Strings;

import java.util.Random;

public class RandomString {
    static String generate(int size){
        //random char= 97+(int)(random float)
        //26X random float can give any value 0 to 26
        Random random=new Random();
       // System.out.println(random.nextFloat());
        StringBuffer sb=new StringBuffer(size);
        for (int i = 0; i < size; i++) {
        int randomChar=97+(int)(random.nextFloat()*26);
        sb.append((char) randomChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str=generate(10);
        System.out.println(str);
    }
}
