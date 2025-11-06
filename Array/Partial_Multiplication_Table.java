import java.util.*;
public class Partial_Multiplication_Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to display its multiplication table (from 6 to 9): ");
        int number = sc.nextInt();
        int[] multiplicationResult = new int[4]; 
        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index++] = number * i;
        }
        System.out.println("\nMultiplication Table for " + number + " (from 6 to 9) :");
        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index++]);
        }
    }
}