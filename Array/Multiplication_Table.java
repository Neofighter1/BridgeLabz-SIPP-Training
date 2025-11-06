import java.util.*;
public class Multiplication_Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to display its multiplication table (1 to 10): ");
        int number = sc.nextInt();
        int[] multiplicationResults = new int[10];
        for (int i = 0; i < 10; i++) {
            multiplicationResults[i] = number * (i + 1);
        }
        System.out.println("\nMultiplication Table for " + number + ":");
        for (int i = 0; i < 10; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationResults[i]);
        }
    }
}