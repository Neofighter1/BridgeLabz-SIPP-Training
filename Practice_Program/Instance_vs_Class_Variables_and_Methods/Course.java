package Instance_vs_Class_Variables_and_Methods;

public class Course {

    String courseName;
    int duration;
    double fee;
    static String instituteName = "GLA Institute";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

   public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    public static void updateInstituteName(String newName) {
        instituteName = "GL Bajaj";
    }

    public static void main(String[] args) {
        Course obj1 = new Course("Java Programming", 3, 5000);
        Course obj2 = new Course("Web Development", 4, 7000);
        
        obj1.displayCourseDetails();
        System.out.println();
        obj2.displayCourseDetails();
        System.out.println();

        Course.updateInstituteName("XYZ Academy");

        obj1.displayCourseDetails();
        System.out.println();
        obj2.displayCourseDetails();
    }
}
