import java.util.*;
public class ArrayIndexDemo {
    static void generate(String[] arr) {
        System.out.println(arr[10]);
    }
    static void handle(String[] arr) {
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) arr[i] = sc.next();
        // generate(arr);
        handle(arr);
    }
}