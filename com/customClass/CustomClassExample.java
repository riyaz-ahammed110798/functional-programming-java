package com.customClass;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
    //if the type is primitive use the  primitive type map
    public static void main(String[] args) {
        List<Course> courseListNull = new ArrayList<>();
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

        Comparator<Course> byIncreasingScore = Comparator.comparing(Course::getScore);
        Comparator<Course> byDecreasingScore = Comparator.comparing(Course::getScore).reversed();
        Comparator<Course> byScoreEnrolled = Comparator.comparing(Course::getScore).thenComparing(Course::getEnrolled);
        System.out.println(
                courseList.stream().sorted(byIncreasingScore).collect(Collectors.toList())
        );
        System.out.println(
                courseList.stream().sorted(byDecreasingScore).collect(Collectors.toList())
        );
        System.out.println(
                courseList.stream().sorted(byScoreEnrolled).collect(Collectors.toList())
        );

        System.out.println(
                courseList.stream()
                        .sorted(byScoreEnrolled)
                        .limit(3) //limit to the first 3
                        .collect(Collectors.toList())
        );

        System.out.println(
                courseList.stream()
                        .sorted(byScoreEnrolled)
                        .skip(2) //skip the first 2 from the list
                        .collect(Collectors.toList())
        );

        System.out.println(
                courseList.stream()
                        .takeWhile(course -> course.getScore() >= 90) //if any of the stream breaks this criteria it wont take any value after that
                        .collect(Collectors.toList())
        );

        System.out.println(
                courseList.stream()
                        .dropWhile(course -> course.getScore() == 91) //if any of the stream has a same criteria it will be dropped
                        .collect(Collectors.toList())
        );


        System.out.println(
                courseList.stream()
                        .max(Comparator.comparing(Course::getEnrolled)) //gets the course with top enrolled
        );

        System.out.println(
                courseList.stream()
                        .min(Comparator.comparing(Course::getEnrolled)) //gets the course with least enrolled
        );

        System.out.println(
                courseListNull.stream()
                        .findFirst() //gets the first course in the list
                        .orElse(new Course("No Name", "No Category", 0, 0)) // if the list is null it will return the default course details
        );

        Predicate<Course> coursePredicate = course -> course.getScore() > 95;
        System.out.println(
                courseList.stream()
                        .filter(coursePredicate)
                        .findAny()//gets the course with least enrolled
        );


        System.out.println(
                courseList.stream()
                        .filter(coursePredicate)
                        .mapToInt(Course::getEnrolled)
                        .sum()
        );

        System.out.println(
                courseList.stream()
                        .filter(coursePredicate)
                        .mapToInt(Course::getScore)
                        .average()
        );

        System.out.println(
                courseList.stream()
                        .filter(course -> course.getCategory() == "Microservices")
                        .count()
        );

        System.out.println(
                courseList.stream()
                        .collect(Collectors.groupingBy(Course::getCategory))
        );

        System.out.println(
                courseList.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );

        System.out.println(
                courseList.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getScore))))
        );

        System.out.println(
                courseList.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList())))
        );




    }
}
