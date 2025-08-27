
// Functional Interface - String Length Checker
import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthChecker = s -> s.length();

        String msg = "Hello Java";
        System.out.println("Length: " + lengthChecker.apply(msg));
    }
}
