package Access_Modifiers;

public class Student {
	public int rollNumber;
	protected String name;
	private double CGPA;
	
	
	
	public Student(int rollNumber,String name, double CGPA){
		this.rollNumber= rollNumber;
		this.name= name;
		this.CGPA=CGPA;
	}
	public double getCGPA() {
		return CGPA;
	}
	
	public void cgpaModify(double newCgpa) {
		if(newCgpa<=10 && newCgpa>0) {
			
			
			this.CGPA = newCgpa;
		}
		else {
			System.out.print("New Cgpa is in valid");
		}
		
	}
	public void display() {
		System.out.println("Rollnumber of the student " +rollNumber);
		System.out.println("Name of the student " +name);
		System.out.println("CGPA of the student " +CGPA);	
		
	}
	
	class PostGraduateStudent{
		public int rollNumberOfPG;
		protected String nameOfPG;
		private double CGPAofPG;
		
		private String specialization ;
		public PostGraduateStudent(int rollNumberOfPG,String nameOfPG, double CGPAofPG  ,String specialization) {
			this.rollNumberOfPG= rollNumberOfPG;
			this.nameOfPG= nameOfPG;
			this.CGPAofPG=CGPAofPG;
			this.specialization =specialization;
		}
		public void display2() {
			System.out.println("Rollnumber of the student " +rollNumberOfPG);
			System.out.println("Name of the student " +nameOfPG);
			System.out.println("CGPA of the student " +CGPAofPG);
			System.out.println("Specialization of the student " +specialization);
		}
		
		
		
		
		
	}
	
	public static void main(String[] args) {
	Student obj1 = new Student(2215786,"Hemant",8.06);
	obj1.cgpaModify(9.07);
	System.out.println( "Modify CGPA "+ obj1.getCGPA());
	obj1.display();
	//System.out.println();
	System.out.println("\nDetails of postgraduate Student :");
//	System.out.println();
	PostGraduateStudent obj2 =obj1.new PostGraduateStudent(2215345,"Anuj",9.99,"Computer Science");
	obj2.display2();	

	}

}

