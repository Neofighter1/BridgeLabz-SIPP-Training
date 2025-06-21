import java.util.*;
public class ToUpperCompare {
    static String manualToUpper(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') ch = (char)(ch - 32);
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
        String manual = manualToUpper(s);
        String builtin = s.toUpperCase();
        System.out.println("Equal: " + compare(manual, builtin));
    }
}