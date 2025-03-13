package com.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Basics {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,3,4,5,11,21,13,12,10);
        printSquareOddNumbers(data);

    }

    static void printNumbers(List<Integer> numbers){
        numbers.stream()
                .forEach(System.out::println);//method reference basic

    }

    static void printEvenNumbers(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number % 2 == 0) // filter only the even numbers from the list where the number is the input paramter and check if that number is %2 or notList<Integer> numbers = Arrays.asList(1,3,4,5,11,21,13,12,10);
                .forEach(System.out::println);//method reference basic

    }

    static  void printSquareOddNumbers(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number)// do some changes to the stream values
                .forEach(System.out::println);
    }


}
