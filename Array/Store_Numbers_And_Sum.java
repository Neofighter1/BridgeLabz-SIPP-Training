import java.util.*;
public class Store_Numbers_And_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        System.out.println("Enter numbers (enter 0 or a negative number to stop, max 10 entries):");
        while(true){
            System.out.print("Enter number:");
            double userInput = sc.nextDouble();
            if (userInput <= 0) {
                break;
            }
            if (index == 10) {
                System.out.println("Array is full. Cannot add more numbers.");
                break;
            }
            numbers[index++] = userInput;
        }
        System.out.println("Entered Numbers");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }
        System.out.println();
        System.out.println("Sum of all numbers: " + total);
    }
}