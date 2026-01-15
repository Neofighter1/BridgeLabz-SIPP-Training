
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void displayRole() {
        System.out.println("Role: Person in the school system");
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

   
    public void displayRole() {
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
        System.out.println();
    }
}

class Students extends Person {
    String grade;

    public Students(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
        System.out.println();
    }
}

// Subclass: Staff
class Staff extends Person {
    String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    
    public void displayRole() {
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
        System.out.println();
    }
}


public class SchoolSystem {
    public static void main(String[] args) {
        
        Teacher teacher = new Teacher("Hemant", 40, "Math");
        Students student = new Students("Anuj", 16, "10th Grade");
        Staff staff = new Staff("Madhav", 35, "Administration");

        
        Person[] people = {teacher, student, staff};

        for (Person person : people) {
            person.displayInfo();
            person.displayRole();
        }
    }
}
