import java.util.*;
class Fees_Discount2{
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		float fee=sc.nextInt();
		float discountPercent=sc.nextInt();
		float discount=fee*(discountPercent/100);
		float final_fee=fee-discount;
		System.out.printf("The discount amount in INR %.0f and final discounted fee is INR %.0f",discount,final_fee);
	}
}