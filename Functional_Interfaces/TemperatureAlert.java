
// Functional Interface - Temperature Alert
import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> alert = t -> t > 30.0;
        double temp = 35.0;

        if(alert.test(temp)) {
            System.out.println("ALERT: Temperature is high!");
        } else {
            System.out.println("Temperature is normal.");
        }
    }
}
