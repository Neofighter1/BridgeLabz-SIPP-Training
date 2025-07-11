
import java.util.HashSet;

public class StringBuilder_RemoveDuplicates {
    public static void main(String[] args) {
        String input = "banana";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        System.out.println(sb.toString());
    }
}
