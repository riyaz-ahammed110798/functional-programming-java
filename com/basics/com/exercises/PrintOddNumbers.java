package com.basics.com.exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PrintOddNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,4,5,11,21,13,12,10);
        System.out.print(collectAsListEven(numbers));
    }

    static void printOddNumber(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number %2 != 0)
                .forEach(System.out::println);
    }

    static void printCubeOddNumber(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number %2 != 0)
                .map(number -> Math.pow(number, 3))
                .forEach(System.out::println);
    }

    static void printSumSquare(List<Integer> numbers){
        System.out.print("Sum of square of numbers = " + numbers.stream()
                .map(number -> Math.pow(number, 2))
                .reduce(0.0, Double::sum));
    }

    static void printSumCube(List<Integer> numbers){
        System.out.print("Sum of cube of numbers = " + numbers.stream()
                .map(number -> Math.pow(number, 3))
                .reduce(0.0, Double::sum));
    }

    static void printSumOdd(List<Integer> numbers){
        System.out.print("Sum of odd numbers = " + numbers.stream()
                .filter(number -> number % 2 != 0)
                .reduce(0, Integer::sum));
    }

    static List<Double> collectAsList(List<Integer> numbers){
        return numbers.stream()
                .map(number -> Math.pow(number, 2))
                .collect(Collectors.toList());
    }


    static List<Integer> collectAsListEven(List<Integer> numbers){
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    }
}
