class Pen_Distribution{
	public static void main(String [] args){
		int totalpen=14;
		int totalstudent=3;
		int spp=totalpen/totalstudent;
		System.out.printf("The Pen Per Student is %d and the remaining pen not distributed is %d",spp,totalpen-spp*totalstudent);
	}
}