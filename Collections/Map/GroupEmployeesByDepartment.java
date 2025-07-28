package Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



class Employee {
    private String name;
    private String department;
 
    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Tarun", "HR"),
                new Employee("Suryansh", "IT"),
                new Employee("Arjun", "HR"),
                new Employee("Abhay", "Finance"),
                new Employee("Arihant", "IT")
        );

        HashMap<String,List<Employee>> employeeMap = new HashMap<>();

        for (Employee e : employees) {
            if (!employeeMap.containsKey(e.getDepartment())) {
                employeeMap.put(e.getDepartment(),new ArrayList<>());
            }
            employeeMap.get(e.getDepartment()).add(e);
        }

        System.out.println(employeeMap);
    }
}