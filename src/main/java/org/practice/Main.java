package org.practice;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
      //  System.out.println("The volume of cuboid is:"+calVolume(3,4,5));
        Box box=new Box(2,4,6);
        Box box1=new BoxWeight(2,3,4,6);
        String str="kriti";
        Main m=new Main();
        m.reverse(str);
        System.out.println(str);
        int[] nums={1,3,4,7,9,9,6};
        System.out.println(m.kthsmallelement(nums,3));
        System.out.println("--------------------------");
        System.out.println(m.kthlargeelement(nums,5));
        int[] numsrev=m.mergeSort(nums);
        System.out.println(Arrays.toString(numsrev));
        List<Box> list=new ArrayList<>();
        int n=12334566;
        int[] arr={1,2,4};
        System.out.println(m.fib(10));
        System.out.println(m.reverse(n,0));
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        System.out.println(averageOfArr(arr,2));
        System.out.println("--------------------------");



    }
    public static int averageOfArr(int[] nums, int s){
        int ctr=0;
        int sum=0;
        int average=1;

        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums.length; i++) {
                sum+=nums[i];

                list.add(sum/average++);
                }


//                int average=i;
//                average++;
//                sum=sum/average;
               // System.out.println(average);
              //  System.out.println(sum);



        for(int i=0;i<list.size();i++){
            if(list.get(i)==s){
                ctr++;
            }
        }


        return ctr;

    }



    public int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;}
            int mid=arr.length/2;
            int[] left=mergeSort(Arrays.copyOfRange(arr,0,mid));
            int[] right=mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
            return merge(left,right);
        }

    public int[] merge(int[] first,int[] second){
        int[] merged=new int[first.length+second.length];
        //pointers for all three arrays

        int i=0;
        int j=0;
        int k=0;
        if(first[i]<second[j]){
            merged[k]=first[i];
            i++;
            k++;
        }
        else {
            merged[k]=second[j];
        j++;
        k++;}
        while(i<first.length){
            merged[k]=first[i];
            k++;
            i++;
        }
        while(j<second.length){
            merged[k]=second[j];
            k++;
            j++;
        }
        return merged;
    }
    public int kthsmallelement(int[] num, int k){
        k--;
        Set<Integer> set=new TreeSet<>();
        for (int i = 0; i < num.length; i++)
            set.add(num[i]);
            Iterator itr=set.iterator();
            while(k>0){
               itr.next();
                k--;
            }
            int r=(int)itr.next();
        return r;
    }
    public int kthlargeelement(int[] num, int k){
        Set<Integer> set=new TreeSet<>();
        for (int i = 0; i < num.length; i++)
            set.add(num[i]);
        Iterator itr=set.iterator();

        k= set.size()-k;
        while(k>0){
            itr.next();
            k--;
        }
        int r=(int)itr.next();
        return r;
    }
    public int reverse(int n,int temp){
        if(n==0){
            return temp;
        }
        temp=(temp*10)+(n%10);
        return reverse(n/10,temp);
    }


    public void reverse(String str){
        if(str==null||str.length()<=1)
        {
            System.out.println(str);
        }
        else{
            System.out.print(str.charAt(str.length()-1));
            reverse(str.substring(0,str.length()-1));
        }
    }
    public int fib(int n){
        if(n<=1){
            return 1;}
            return n*fib(n-1);
        }
    }
