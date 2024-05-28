package org.practice;

import java.util.HashMap;
import java.util.Map;

public class pString {
    public static int patternSearching(String s)
    {
        if(s.length()==0)
            return 0;
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        int max=0;
        for(int i=0,j=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
                System.out.println(j);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
    public static void main(String[] args)
    {
        String str="AABAACAADAABAABA";
        System.out.println("Result: "+patternSearching(str));
        StringBuffer s=new StringBuffer();
        

    }
}
