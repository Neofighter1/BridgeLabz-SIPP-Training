
// Static Methods in Interface - Date Format Utility
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
    static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}

public class DateFormatUtility {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("dd/MM/yyyy: " + DateUtils.formatDate(today, "dd/MM/yyyy"));
        System.out.println("yyyy-MM-dd: " + DateUtils.formatDate(today, "yyyy-MM-dd"));
    }
}
