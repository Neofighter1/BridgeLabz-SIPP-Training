package Level_1;
import java.util.*;
public class Person {


    int age;
    String name;

    Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    Person(Person p){
        this.age = p.age;
        this.name = p.name;
    }

   public void print(){
        System.out.println("The name of person is:"+name);
        System.out.println("The age of person is:"+age);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name:");
        String name = sc.nextLine();
        System.out.println("Enter the age:");
        int age = sc.nextInt();
        Person para_person = new Person(age,name);
        System.out.println("Person info using parameter constructor-");
        para_person.print();
        Person copy_person = new Person(para_person);
        System.out.println("Person info using copy constructor-");
        copy_person.print();
    }
}