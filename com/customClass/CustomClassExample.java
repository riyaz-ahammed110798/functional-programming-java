package com.customClass;


import java.util.List;
import java.util.function.Predicate;

class Course{

    private String name;
    private String category;
    private int score;
    private int enrolled;

    public Course(String name, String category, int score, int enrolled) {
        this.name = name;
        this.category = category;
        this.score = score;
        this.enrolled = enrolled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", score=" + score +
                ", enrolled=" + enrolled +
                '}';
    }
}
public class CustomClassExample {

    public static void main(String[] args) {

        List<Course> courseList = List.of(
                new Course("Spring", "Framework", 98, 1001),
                new Course("Spring Boot", "Framework", 91, 101),
                new Course("API", "Microservices", 80, 1099),
                new Course("AWS", "Cloud", 93, 3333),
                new Course("Docker", "Cloud", 100, 1340)
        );

        Predicate<Course> score90PRedicate = course -> course.getScore() > 90;
        Predicate<Course> score90PRedicateNone = course -> course.getScore() > 100;
        Predicate<Course> score90PRedicateAny = course -> course.getScore() == 100;

        System.out.println(
                courseList.stream().allMatch(score90PRedicate)
        );

        System.out.println(
                courseList.stream().noneMatch(score90PRedicateNone)
        );

        System.out.println(
                courseList.stream().anyMatch(score90PRedicateAny)
        );

    }
}
