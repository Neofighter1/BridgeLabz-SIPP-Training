import java.util.*;
// Interface

interface Department{
	void assignDepartment(String department) ;
	String getDepartmentDetails();
}

// Abstract class
abstract class Employees implements Department{
	private int employeeId;
	private String name;
	private int baseSalary;
	private String department;
	
	public Employees(int employeeId,String name,int baseSalary) {
		this.employeeId=employeeId;
		this.name = name;
		this.baseSalary=baseSalary;
	}
	
	// abstract method
	public abstract int calculateSalary();
	public void displayDetails() {
		System.out.println("EmployeeID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println("\n");
	}
	
	//Encapsulation 
	public int getEmployeeId() {
		return employeeId;
		
	}
	public String getName() {
		return name;
	}
	public int getBaseSalary() {
		return baseSalary;
	}
	@Override
	public void assignDepartment(String department) {
		this.department = department;
	}
	@Override
	public String getDepartmentDetails() {
		return department;
	}
}
class FullTimeEmployee extends Employees{
	private int bonus;
	public FullTimeEmployee(int employeeId,String name, int baseSalary, int bonus) {
		super(employeeId, name,baseSalary);
		this.bonus = bonus;
	}
	
	@Override
	public int calculateSalary() {
		return getBaseSalary()+bonus;
	}
}

class PartTimeEmployee extends Employees{
	private int hoursWorked;
	private int hourlyRate;
	
	public PartTimeEmployee(int employeeId, String name, int baseSalary,int hoursWorked,int hourlyRate) {
		super(employeeId,name,baseSalary);
		this.hoursWorked= hoursWorked;
		this.hourlyRate=hourlyRate;
	}
	@Override
	public int calculateSalary() {
		return getBaseSalary()+(hoursWorked * hourlyRate);
	}
}
public class employeeManagement{
	public static void main(String[] args) {
		FullTimeEmployee emp1 = new FullTimeEmployee(11,"Anuj",3400,200);
		PartTimeEmployee emp2 = new PartTimeEmployee(12,"Madhav", 1200,13,48);
        
        emp1.assignDepartment("HR");
        emp2.assignDepartment("Support");

        //Polymorphism
        List<Employees> employeeList = new ArrayList<>();
        employeeList.add(emp1);
        employeeList.add(emp2);


        for (Employees emp : employeeList) {
            emp.displayDetails();
        }
		
	}
}



