package com.basics.com.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAllCourses {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices using spring", "AWS", "PCP", "Azure", "Docker","Spring JPA Repository");
        System.out.print(stringLength(courses));
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
}
