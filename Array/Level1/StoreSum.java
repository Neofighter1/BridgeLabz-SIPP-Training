import java.util.*;
public class StoreSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double sum = 0;
        int i = 0;
        while (true) {
            double num = sc.nextDouble();
            if (num <= 0 || i == 10) break;
            arr[i++] = num;
        }
        for (int j = 0; j < i; j++) sum += arr[j];
        System.out.println("Sum = " + sum);
    }
}