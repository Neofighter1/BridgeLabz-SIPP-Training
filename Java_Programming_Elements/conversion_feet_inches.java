import java.util.*;
class conversion_feet_inches{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		float height=input.nextInt();
		float inches=height/(float)2.54;
		float feet=inches/(float)12;
		System.out.printf("Your Height in cm is %.2f while in feet is %.2f and inches is %.2f",height,feet,inches);
	}
}