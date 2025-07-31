class Fees_Discount{
	public static void main(String [] args){
		float fee=125000;
		float discountPercent=10;
		float discount=fee*(discountPercent/100);
		float final_fee=fee-discount;
		System.out.printf("The discount amount in INR %.0f and final discounted fee is INR %.0f",discount,final_fee);
	}
}