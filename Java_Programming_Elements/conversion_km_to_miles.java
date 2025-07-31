import java.util.*;
class conversion_km_to_miles{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		double km=input.nextInt();
		System.out.printf("The total miles is %.2f mile for the given %.2f km",km*1.6,km);
	}
}