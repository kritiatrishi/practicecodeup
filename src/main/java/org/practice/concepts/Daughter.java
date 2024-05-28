package org.practice.concepts;

public class Daughter extends Parent{
    @Override
    void career(String name) {
        System.out.println("I am a daughter and I am going to be a "+name);
    }

    @Override
    void partner(String name, int age) {
        System.out.println("I love a man named "+name+" who's age is "+age);
    }
}
