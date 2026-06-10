package org.practice.questions;

import java.util.Arrays;

public class Iquestions {
    //--------------------amazon questions-------------------------

    public static int gameOfSticks(int[] arr){
        if(arr.length<4){
            return -1;
        }
        int max=Integer.MIN_VALUE;

        for (int i =0,j=3; i <arr.length&&j<arr.length; j++,i++) {

            max=Math.max(max,window(arr,i,j));

        }
        return max;
    }
    public static int window(int[] arr,int i,int j){
        int[] a=new int[4];
        int k=0;
        a[k++]=arr[i];
        a[k++]=arr[i+1];
        a[k++]=arr[j-1];
        a[k]=arr[j];
        if(a[0]-a[1]==1){
            a[0]--;
        }
        if(a[1]-a[0]==1){
            a[1]--;
        }
        if(a[2]-a[3]==1){
            a[2]--;
        }
        if(a[3]-a[2]==1){
            a[3]--;
        }
        if(a[0]==a[1]&&a[2]==a[3]){
            return a[0]*a[2];
        }

        return 0;
    }

    //--------------------mitratech questions----------------------

    public static int stockCal(int[] prices){
        int maxProfit=0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1])
            {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;

    }


    public static int[] leastInteger(int[] arr){
        int[] result=new int[arr.length];
        int min=-1;
        for (int i = 0; i <arr.length-1; i++) {
            if(arr[i]>arr[i+1]){
                result[i]=Math.min(min,arr[i]);
                result[i+1]=Math.min(min,arr[i+1]);
            }
            if(arr[i]<arr[i+1]){
                result[i]=min;
                result[i+1]=arr[i];
            }
            min=Math.max(result[i],result[i+1]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr={5,3,1,9,7,3,4,1};
        int[] a={2,4,5,1,7};
        int[] b={3,4,5,5,6};
        int[] c={10,20,4,5,9};
        System.out.println(Arrays.toString(leastInteger(a)));
        System.out.println("-----------------------------");
        System.out.println(gameOfSticks(b));
        System.out.println("-----------------------------");
        System.out.println(stockCal(c));
    }

}
