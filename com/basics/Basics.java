package com.basics;

import java.util.ArrayList;
import java.util.List;

public class Basics {
    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>(){{
            add(1);add(4);add(5);add(7);
            add(8);add(94);add(11);add(54);
        }};
        printNumbers(data);

    }

    static void printNumbers(List<Integer> numbers){
        numbers.stream()
                .forEach(System.out::println);//method reference basic

    }
}
