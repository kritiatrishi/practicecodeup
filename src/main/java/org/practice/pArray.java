package org.practice;

import java.util.Arrays;

public class pArray {

    public static void findLargest(int[] arr){
        Arrays.sort(arr);
        int n=arr.length;

        int first=arr[n-1];
        int second=arr[n-2];
        int third=arr[n-3];
        int check=0;
        int count=1;
        System.out.println("THe largest: "+first+" the second largest: "+second+"the third largest: "+third);
      /*  for(int i=0;i<n;i++)
        {
            if(count<4)
            {
                if(check!=arr[n-i]) {
                    System.out.print(arr[n - i] + " ");
                    check = arr[n - i];
                    count++;
                }
            }
            else
                break;
        }*/
    }
    public static int[] selectSort(int[] arr)
    {
        for(int i=0; i<arr.length-1;i++)
        {
            int min=i;
            for(int j=i+1;j<arr.length;j++)
            {
            if(arr[j]<arr[min])
            {
                min=j;
                int temp=arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
            }
            }
        }
        return arr;
    }
    public static int kSmallElement(int[] arr, int k)
    {
        int l=arr.length;
        Arrays.sort(arr);
        for(int i=0;i<l;i++)
        System.out.println(arr[i]);
        return arr[k-1];
    }

    public static void revArray(int[] arr)
    {
        int c=0;
        int sum=0;

        for(int i=0;i<arr.length+1;i++)
        {   if(arr[i]!=0)
            sum+=arr[i];
            arr[i]=arr[i+1];
            c=sum%10;

            System.out.println("the sum val:"+sum+" the c val:"+c);

            System.out.println("the arr[i] val:"+arr[i]+" the c val:"+sum%10);
        }
    }

    public static void main(String[] args){
        int[] arr={23,65,78,98,12,1,67,89,98,72};
        int[] arr1={1,2,3,4,6,5,7,8,9,8};
        findLargest(arr);
        System.out.println(kSmallElement(arr,4));
        selectSort(arr);
        for(int i=0;i<arr.length;i++)
        System.out.println(arr[i]);
        revArray(arr1);

    }


}
