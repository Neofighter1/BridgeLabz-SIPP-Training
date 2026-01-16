import java.util.*;
public class ToLowerCompare {
    static String manualToLower(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
            res += ch;
        }
        return res;
    }
    static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String manual = manualToLower(s);
        String builtin = s.toLowerCase();
        System.out.println("Equal: " + compare(manual, builtin));
    }
}