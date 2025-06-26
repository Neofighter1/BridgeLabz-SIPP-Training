package Access_Modifiers;

 class Employee {
 public int employeeID;         
 protected String department;    
 private double salary;          

 
 public Employee(int employeeID, String department, double salary) {
     this.employeeID = employeeID;
     this.department = department;
     this.salary = salary;
 }

 
 public void setSalary(double salarys) {
     if (salary >= 0) {
         this.salary = salarys;
     } else {
         System.out.println("Invalid salary amount.");
     }
 }

 
 public double getSalary() {
     return salary;
 }

 public void displayEmployee() {
     System.out.println("Employee ID: " + employeeID);
     System.out.println("Department: " + department);
     System.out.println("Salary: " + salary);
 }
}


class Manager extends Employee {
 

 public Manager(int employeeID, String department, double salary) {
     super(employeeID, department, salary);
     
 }

 // Method demonstrating access to public and protected members
 public void displayManagerDetails() {
     System.out.println("Manager ID (public): " + employeeID);
     System.out.println("Department (protected): " + department);
     
 }
}


public class EmployeeTest {
 public static void main(String[] args) {
     Manager obj = new Manager(1001, "IT", 75000.0);
 
     
     obj.displayEmployee();

     
     obj.setSalary(80000.0);
     
     System.out.println("\nUpdated Salary: " + obj.getSalary());

     System.out.println("\nManager Details:");
     obj.displayManagerDetails();
 }
}
