package com.basics.com.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAllCourses {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices using spring", "AWS", "PCP", "Azure", "Docker","Spring JPA Repository");
        List<String> courses2 = Arrays.asList("Spring", "Spring Boot", "API", "Microservices using spring", "AWS", "PCP", "Azure", "Docker","Spring JPA Repository");
        System.out.println(tupleTwoListUsingLength(courses, courses2));

    }

    static void printCources(List<String> courses){
        courses.stream()
                .forEach(System.out::println);
    }

    static void printContainsSpring(List<String> courses){
        courses.stream()
                .filter(course -> course.contains("Spring") || course.contains("spring"))
                .forEach(System.out::println);
    }

    static void printCharAtleastFour(List<String> courses){
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    static void printCharLength(List<String> courses){
        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }

    static void printReverseOrder(List<String> courses){
        //courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.comparing(course -> course.length())).forEach(System.out::println);
    }

    static List<String> stringLength(List<String> courses){
        return courses.stream()
                .sorted(Comparator.comparing(course -> course.length()))
                .map(course -> course + " = "+ course.length())
                .collect(Collectors.toList());
    }

    static  String delimitedSep(List<String> courses){
        return courses.stream()
                .collect(Collectors.joining("|"));
    }

    static List<String> charSeperated(List<String> courses){
        return courses.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }

    static List<List<String>> tupleTwoList(List<String> courses, List<String> courses2){
        return courses.stream()
                .flatMap(course ->  courses2.stream()
                        .map(course2 -> List.of(course, course2)))
                .collect(Collectors.toList());
    }

    static List<List<String>> tupleTwoListUsingLength(List<String> courses, List<String> courses2){
        return courses.stream()
                .flatMap(course ->  courses2.stream()
                        .filter(course2 -> course2.length() == course.length()) // use this
                        .map(course2 -> List.of(course, course2)))
                //.filter(list -> list.get(0).equals(list.get(1)))
                //.filter(list -> list.get(0).length() == list.get(1).length())  //instead of this we can use the above filter
                .collect(Collectors.toList());
    }
}
