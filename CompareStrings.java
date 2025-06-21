import java.util.*;
public class CompareStrings {
    static boolean compareCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();
        boolean result1 = compareCharAt(s1, s2);
        boolean result2 = s1.equals(s2);
        System.out.println("Custom compare: " + result1);
        System.out.println("equals() compare: " + result2);
    }
}