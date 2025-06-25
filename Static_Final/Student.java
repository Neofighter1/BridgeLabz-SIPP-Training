public class Student {
    private static String universityName = "State University";
    private static int totalStudents = 0;
    private final String rollNumber;
    private String name;
    private String grade;

    public Student(String name, String rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayStudentDetails(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            System.out.println("University: " + universityName);
            System.out.println("Name: " + student.name);
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Grade: " + student.grade);
        } else {
            System.out.println("Invalid student object.");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", "R001", "A");
        Student s2 = new Student("Bob", "R002", "B");
        s1.displayStudentDetails(s1);
        System.out.println();
        s2.displayStudentDetails(s2);
        System.out.println();
        displayTotalStudents();
    }
}
