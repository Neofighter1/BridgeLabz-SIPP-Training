import java.util.*;
class purchase_price{
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.print("unitPrice: ");
	double unitPrice=input.nextDouble();
	System.out.print("quantity: ");
	int quantity=input.nextInt();
	double total=unitPrice*quantity;
	System.out.println("The total purchase price is INR "+total+" if the quantity "+quantity+" and unit price is INR "+unitPrice);
	}
}