package org.practice;

import java.util.*;

public class Sectional {

    private int h;
    private int b;
    private int l;
    static String conc(){
        String a="abcdef";
        String b="ghcclpod";
        String r="";
        for(int i=0;i<a.length();i++)
            for(int j=0;j<b.length();j++)
                if(a.charAt(i)==b.charAt(j)) r=r+a.charAt(i);
        return r;
    }
    static int calVolume(int l,int b,int h)
    {
        int volume=l*b*h;
        return volume;
    }

    public static void main(String[] args) {

        System.out.println("The volume of cuboid is:"+calVolume(3,4,5));
        System.out.println("The array: ");
        int N=10;
        quickFind(N);
        connected(5, 0);
        union(5,0);
        connected(5, 4);
        union(1,0);
        printInt(N);
        int[] arr={0,1,2,3,4,5,6,7,8,9};
        System.out.println("The string: "+conc());
        List<int[]> list=splitArray(arr,3);
        System.out.println("The new arr: ");
        list.forEach(splitArray->System.out.println(Arrays.toString(splitArray)));

    }
    public static List<int[]> splitArray(int[] array, int splitSize) {
        List<int[]> arraylist = new ArrayList<>();
        int l = array.length;
        int start=0;
        int end=0;
        int s=l/splitSize;
        int[] r = new int[splitSize];
        if (l % splitSize == 0) {
            for (int i = 0; i < s; i++) {
                end+=splitSize;
                arraylist.add(Arrays.copyOfRange(array,start,end));
                start=end;

            }
            }

         else {
            arraylist.add(Arrays.copyOfRange(array,start,start+(l/splitSize)));

        }
            return arraylist;

    }
        private static int[] id;

    static void quickFind(int N){
        id=new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;


    }
    public static boolean connected(int p,int q){
        return id[p]==id[q];
    }
    public static void union(int p, int q){
        int pid=id[p];
        int qid=id[q];
        for(int i=0;i<id.length;i++)
            if(id[i]==pid) id[i]=qid;
    }
    public static void printInt(int N)
    {
        for(int i=0;i<N;i++)
        System.out.println(id[i]);
    }
}
