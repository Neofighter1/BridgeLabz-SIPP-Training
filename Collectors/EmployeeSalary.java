package Collectors;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String dept;
    double salary;
    Employee(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
    String getDepartment() { return dept; }
    double getSalary() { return salary; }
}

public class EmployeeSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Amit", "IT", 50000),
            new Employee("Riya", "HR", 40000),
            new Employee("Satyam", "IT", 60000),
            new Employee("Neha", "HR", 45000)
        );

        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        System.out.println(avgSalaryByDept);
    }
}