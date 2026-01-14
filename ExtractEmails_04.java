import java.util.regex.*;

public class ExtractEmails_04 {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        Matcher matcher = Pattern.compile("[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}").matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
