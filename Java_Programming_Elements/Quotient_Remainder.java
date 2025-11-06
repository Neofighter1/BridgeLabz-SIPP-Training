import java.util.*;
class Quotient_Remainder{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("number1: ");
		int number1=input.nextInt();
		System.out.print("number2: ");
		int number2=input.nextInt();
		int q=number1/number2;
		int r=number1%number2;
		System.out.println("The Quotient is "+q+" and Reminder is "+r+" of two number "+number1+" and "+number2);
	}
}
