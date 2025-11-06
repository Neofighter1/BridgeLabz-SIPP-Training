import java.util.*;
public class PosNegEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < 5; i++) a[i] = sc.nextInt();
        for (int i = 0; i < 5; i++) {
            if (a[i] > 0) {
                if (a[i] % 2 == 0) System.out.println(a[i] + " is positive even");
                else System.out.println(a[i] + " is positive odd");
            } else if (a[i] < 0)
                System.out.println(a[i] + " is negative");
            else
                System.out.println(a[i] + " is zero");
        }
        if (a[0] == a[4]) System.out.println("First and last are equal");
        else if (a[0] > a[4]) System.out.println("First is greater than last");
        else System.out.println("First is less than last");
    }
}