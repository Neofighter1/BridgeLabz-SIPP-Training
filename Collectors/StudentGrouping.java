package Collectors;

import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String grade;
    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
    String getName() { return name; }
    String getGrade() { return grade; }
}

public class StudentGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Aman", "A"),
            new Student("Riya", "B"),
            new Student("Satyam", "A"),
            new Student("Neha", "C")
        );

        Map<String, List<String>> result = students.stream()
            .collect(Collectors.groupingBy(
                Student::getGrade,
                Collectors.mapping(Student::getName, Collectors.toList())
            ));

        System.out.println(result);
    }
}