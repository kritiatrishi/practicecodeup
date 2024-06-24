package org.practice.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static javafx.scene.input.KeyCode.S;

public class StringsMethod {
    public static void main(String[] args) {
        String str = "sdande";
        System.out.println(str);
        System.out.println(str.concat("ghki"));
        str=str.concat("234");
        System.out.println(str);
        String str1=new String("sdande");
        System.out.println(str1);
     //   return (() -> Arrays.stream());
     //   () -> System.out.println(str.charAt(0));
        System.out.println(str.endsWith("234"));
        str.trim();
        String s=str.substring(0,2);
        System.out.println(s);
    }
    }
