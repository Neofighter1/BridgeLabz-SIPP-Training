package Level_1;
import java.util.*;

public class Employees {
	String name;
	int id;
	int salary;
	public Employees(String name,int id,int salary) {
		this.name = name;
		this.id=id;
		this.salary = salary;
	}
	public void display() {
		System.out.println("Employees details : ");
		System.out.println("Employee name : "+name);
		System.out.println("Employees id : "+id);
		System.out.println("Employees salary : " + salary);
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name = input.next();
		int id=input.nextInt();
		int salary = input.nextInt();
		
		Employees obj = new Employees(name,id,salary);
		obj.display();
		

	}

}
