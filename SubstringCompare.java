import java.util.*;
public class SubstringCompare {
    static String makeSubstring(String s, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) result += s.charAt(i);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String manual = makeSubstring(s, start, end);
        String builtIn = s.substring(start, end);
        System.out.println("Manual: " + manual);
        System.out.println("Built-in: " + builtIn);
        System.out.println("Equal: " + manual.equals(builtIn));
    }
}