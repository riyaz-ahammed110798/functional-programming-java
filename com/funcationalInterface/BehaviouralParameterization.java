package com.funcationalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviouralParameterization {
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(34,32,41,55,11,221,123,12,10,51,11,31,11,11,34);
        filterAndPrint(data, number -> number % 2 == 0);
        System.out.print(excerciseBehaviouralParamz(data, number -> number * 10));
    }

    static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate){
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }

    /**
     * Do behavioural parameterization for the mapping logic
     * List squaredNumbers = numbers.stream().map(x -> x*x).collect(Collectors.toList());
     */

    static List<Integer> excerciseBehaviouralParamz(List<Integer> number, Function<Integer, Integer> function){
        return number.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}
