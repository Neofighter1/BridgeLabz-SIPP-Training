class Profit_Percentage{
	public static void main(String [] args){
		float cp=129;
		float sp=191;
		float profit=sp-cp;
		float profit_per=(profit/cp)*100;
		System.out.printf("The Cost Price in INR %.2f and Selling Price in INR %.2f \nThe Profit in INR %.2f and the Profit Percentage is %.2f \n",cp,sp,profit,profit_per);
	}
}