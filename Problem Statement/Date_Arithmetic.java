import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Date_Arithmetic {
    public static void main(String [] args){
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter date (yyyy-MM-dd):");
        String n = sc.nextLine();
        LocalDate date = LocalDate.parse(n);
        LocalDate result = date
                .plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Final Date: " + result.format(formatter));

    }
}
