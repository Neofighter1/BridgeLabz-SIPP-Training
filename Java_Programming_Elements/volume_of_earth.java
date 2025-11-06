class volume_of_earth{
	public static void main(String [] args){
		float r=6378;
		float pi=22/7;
		float v=(4/3)*pi*r*r*r;
		System.out.printf("The volume of earth in cubic kilometers is %.0f and cubic miles is %.0f",v,v*1000000000);
	}
}