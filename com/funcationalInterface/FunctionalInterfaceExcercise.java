package com.funcationalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class FunctionalInterfaceExcercise {
    /**
     *
     * Create an implementation for the Functional Interface
     *
     * int sum = numbers.stream().reduce(0,Integer::sum);
     *
     */
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(34,32,41,55,11,221,123,12,10,51,11,31,11,11,34);
        System.out.print("Sum = " + createFunctional(data));
    }

    static int createFunctional(List<Integer> numbers){
        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };
        return numbers.stream().reduce(0, sumBinaryOperator2);

    }
}
