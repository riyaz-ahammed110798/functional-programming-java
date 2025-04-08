package com.basics.com.exercises;

import java.util.Arrays;
import java.util.List;

public class PrintOddNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,4,5,11,21,13,12,10);
        printSumOdd(numbers);
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
}
