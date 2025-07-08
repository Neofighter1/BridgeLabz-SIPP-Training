package Oops;
import java.util.*;
class student{
    String Name;
    int rollno;
    int marks;
    student(String Name,int rollno, int marks){
        this.Name=Name;
        this.rollno=rollno;
        this.marks=marks;
    }
    public Object[] arr(){
        return new Object[]{this.Name,this.rollno,this.marks};
    }
}
class Student_management_system {
    List<Object[]>data=new ArrayList<>();
    Scanner sc=new Scanner(System.in);
    void Add_new_Student(){
        System.out.println("Add_new_Student:");
        System.out.print("Name:");
        String Name=sc.next();
        System.out.print("Roll.No:");
        int rollno=sc.nextInt();
        System.out.print("Marks:");
        int marks=sc.nextInt();
        student s=new student(Name,rollno,marks);
        data.add(s.arr());
        System.out.println("Added Successfully");
    }
    void display(){
        for(Object[] arr:data){
            System.out.println(arr[0]+"|"+arr[1]+"|"+arr[2]);
        }   
    }
    void searchStudent(){
        System.out.print("Enter Student Name:");
        String search = sc.nextLine();
        boolean found = false;
        for (Object [] i : data) {
            if ((i[0].toString()).equalsIgnoreCase(search)) {
                System.out.println(i[0]+"|"+i[1]+"|"+i[2]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Student");
        }
    }
    void removeStudent(){
        System.out.print("Enter Student Name:");
        String search = sc.nextLine();
        boolean found = false;
        for (Object [] i : data) {
            if ((i[0].toString()).equalsIgnoreCase(search)) {
                System.out.println(i[0]+"|"+i[1]+"|"+i[2]);
                found = true;
                data.remove(i);
                System.out.println("Removed Successfully");
            }
        }
        if (!found) {
            System.out.println("No Student");
        }
    }
    void sortbymarks(){
        int n=data.size();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int marks1=(int)data.get(i)[2];
                int marks2=(int)data.get(j)[2];
                if(marks1>marks2){
                    Object []temp=data.get(i);
                    data.set(i,data.get(j));
                    data.set(j,temp);
                }
            }
        }
        System.out.println("Sorting done");
        display();
    }
    void updateMarks(){
        System.out.print("Enter Student Name:");
        String search = sc.nextLine();
        boolean found = false;
        for (Object [] i : data) {
            if ((i[0].toString()).equalsIgnoreCase(search)) {
                System.out.println(i[0]+"|"+i[1]+"|"+i[2]);
                found = true;
                System.out.println("Enter newMarks:");
                int newmarks=sc.nextInt();
                i[2]=newmarks;
                System.out.println("Updated"+i[0]+"|"+i[1]+"|"+i[2]);
            }
        }
        if (!found) {
            System.out.println("No Student");
        }
    }
}

public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Student_management_system manage =new Student_management_system();
        int choice;
        do {
            System.out.println("\n===== Student Management =====");
            System.out.println("1. Add Student");
            System.out.println("2. All Student");
            System.out.println("3. Search Student");
            System.out.println("4. sortbymarks");
            System.out.println("5. updateMarks");
            System.out.println("6. removeStudent");
            System.out.println("7. Exit");
            System.out.print("Enter choice:");
            choice = sc.nextInt();
            //sc.nextLine();

            switch(choice){
                case 1:
                    manage.Add_new_Student();
                    break;
                case 2:
                    manage.display();
                    break;
                case 3:
                    manage.searchStudent();
                    break;
                case 4:
                    manage.sortbymarks();
                    break;
                case 5:
                    manage.updateMarks();
                    break;
                case 6:
                    manage.removeStudent();
                    break;
                case 7:
                    System.out.println("Exiting. Thank You");
                    break;
                default:
                    System.out.println("Invalid choice.");

            }
        }while(choice !=7);
    }
}
