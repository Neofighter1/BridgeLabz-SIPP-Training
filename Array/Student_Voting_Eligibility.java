import java.util.*;
public class Student_Voting_Eligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        System.out.println("Voting Eligibility");
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0) {
                System.out.printf("Student %d: Invalid age (%d). Age cannot be negative.\n", (i + 1), age);
            } else if (age >= 18) {
                System.out.printf("Student %d: The student with the age %d can vote.\n", (i + 1), age);
            } else {
                System.out.printf("Student %d: The student with the age %d cannot vote.\n", (i + 1), age);
            }
        }
    }
}