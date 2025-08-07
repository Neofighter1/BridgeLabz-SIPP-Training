
import java.util.regex.*;
public class ExtractProgrammingLanguages_12 {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        Matcher matcher = Pattern.compile("\b(Java|Python|JavaScript|Go)\b").matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}