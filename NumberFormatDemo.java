import java.util.*;
public class NumberFormatDemo {
    static void generate(String s) {
        int num = Integer.parseInt(s);
        System.out.println(num);
    }
    static void handle(String s) {
        try {
            int num = Integer.parseInt(s);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Handled NumberFormatException");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // generate(s);
        handle(s);
    }
}