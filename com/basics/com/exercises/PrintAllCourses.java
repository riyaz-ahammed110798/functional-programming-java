package com.basics.com.exercises;

import java.util.Arrays;
import java.util.List;

public class PrintAllCourses {
    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices using spring", "AWS", "PCP", "Azure", "Docker","Spring JPA Repository");
        printCharLength(courses);
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
}
