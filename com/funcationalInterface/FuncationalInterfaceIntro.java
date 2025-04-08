package com.funcationalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FuncationalInterfaceIntro {
    /**
     * Predicate - accepts single input argument and returns boolean
     * Function - accepts single input argument and returns a value
     * Consumer - accepts sinle input argument and returns no value
     *
     */
    public static void main(String[] args) {
        List<Integer> data = Arrays.asList(34,32,41,55,11,221,123,12,10,51,11,31,11,11,34);
        Predicate<Integer> isEven = number -> number % 2 == 0;  //Accept 1 input argument and return boolean
        Function<Integer, Integer> square = number -> number * number;  //Accepts 1 input argument and return a value
        Consumer<Integer> print = number -> System.out.println(number); //Accepts 1 input argument and return no value
        BinaryOperator<Integer> sum = (x, y) -> x + y;  //Accepts 2 input arguments and return 1 of same type
        Supplier<Integer> supplier = () -> {return 12;};    //Accepts nothing and return someting
        Supplier<String> stringSupplier = () -> "Riyaz";
        System.out.print(stringSupplier.get()); // to get the supplier value
        UnaryOperator<Integer> unaryOperator = (x) -> x + 12;   //Accepts 1 input argument and returns value of same type
        System.out.print(unaryOperator.apply(10));    //this assigns 10 for the x


        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x > y ? true : false; //Accepts 2 input arguments and returns boolean
        System.out.println(biPredicate.test(11, 12));
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y; //Accepts 2 input argument and return a value
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x * y);  //Accepts 2 inputs and return nothing
        //printSquareOddNumbers(data);


        //IntBinaryOperator         IntPredicate                IntToLongFUnction
        //IntConsumer               IntSupplier                 IntUnaryOperator
        //IntFunction               IntToDoubleFunction
    }

    static  void printSquareOddNumbers(List<Integer> numbers){
        Predicate<Integer> isOdd = number -> number % 2 != 0;
        Function<Integer, Integer> squreOf = number -> number * number;
        Consumer<Integer> display = System.out::println;
        numbers.stream()
                .filter(isOdd)
                .map(squreOf)// do some changes to the stream values
                .forEach(display);
    }
}
