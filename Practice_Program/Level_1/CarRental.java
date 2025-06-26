package Level_1;
import java.util.*;
public class CarRental {
	String customerName;
	String carModel;
	int rentalDays;

	public CarRental(String customerName, String carModel, int rentalDays) {
		this.customerName=customerName;
		this.carModel=carModel;
		this.rentalDays=rentalDays;
		
	}
	public void display(int perDayCost) {
		System.out.println("Customer Name : " +customerName);
		System.out.println("Car Model Name : " +carModel);
		System.out.println("Rental Days : " +rentalDays);
		System.out.println("Total cost of rental car : " + rentalDays*perDayCost);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter details of car : " );
		System.out.print("Enter customer name : ");
		String customerName = sc.next();
		System.out.print("Enter Car Model name : ");
		String carModel = sc.next();
		System.out.print("Enter days of car rent : ");
		int rentalDays = sc.nextInt();
		CarRental obj = new CarRental(customerName,carModel,rentalDays);
		
		System.out.print("Enter per day cost of car rent : ");
		int perDayCost = sc.nextInt();
		obj.display(perDayCost);
		
		
		
		

	}

}
