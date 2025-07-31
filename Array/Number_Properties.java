import java.util.*;
public class Number_Properties {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 integer numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        System.out.println("Number Properties:");
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.print("Number " + num + " is: ");
            if (num > 0) {
                System.out.print("Positive");
                if (num % 2 == 0) {
                    System.out.println(" and Even.");
                } else {
                    System.out.println(" and Odd.");
                }
            } else if (num < 0) {
                System.out.println("Negative.");
            } else {
                System.out.println("Zero.");
            }
        }
        System.out.println("Comparing First and Last Elements:");
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("The first element (" + numbers[0] + ") is equal to the last element (" + numbers[numbers.length - 1] + ").");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("The first element (" + numbers[0] + ") is greater than the last element (" + numbers[numbers.length - 1] + ").");
        } else {
            System.out.println("The first element (" + numbers[0] + ") is less than the last element (" + numbers[numbers.length - 1] + ").");
        }
    }
}