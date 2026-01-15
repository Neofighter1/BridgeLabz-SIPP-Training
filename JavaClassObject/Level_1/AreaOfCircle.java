package Level_1;
import java.util.*;
public class AreaOfCircle {
	int radius;
	public AreaOfCircle(int radius) {
		this.radius = radius;
		
	}
	public void display() {
		System.out.println("Area of the circle : "+ (double)(3.14*radius*radius));
		System.out.println("Circumference of the circle : "+ (double)(2*3.14*radius));

		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the radius of circle");
		int radius = input.nextInt();
		input.close();
		AreaOfCircle obj = new AreaOfCircle(radius);
		obj.display();
		
		
	}

}
