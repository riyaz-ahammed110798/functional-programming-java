package com.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basics {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(1,3,4,5,11,21,13,12,10,5,11,3,1,1,3);
        List<Integer> data1 = Arrays.asList(34,32,41,55,11,221,123,12,10,51,11,31,11,11,34);
        distinctSortTwoArray(data, data1);

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

    static void printSum(List<Integer> numbers){
        System.out.print( " Sum of Number : " + numbers.stream()
                //.reduce(0, (x,y) -> x + y)
                .reduce(0, Integer::sum));
    }

    static void maxOfNum(List<Integer> numbers){
        System.out.print( " Max of Number : " + numbers.stream()
                .reduce(0, (a, b) -> a > b ? a : b));
    }

    static void distinctOfList(List<Integer> numbers){
        System.out.print("Distinct values : " );
        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
    static void distinctSortTwoArray(List<Integer> number1, List<Integer> number2){
        Stream.concat(number1.stream(), number2.stream()).collect(Collectors.toList()).stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
