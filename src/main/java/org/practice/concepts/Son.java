package org.practice.concepts;

import java.sql.SQLOutput;

public class Son extends Parent {

    @Override
    void career(String name) {
        System.out.println("I am a son and I am going to be a "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love a woman named "+name+" who's age is "+age);
    }
}
