import java.util.*;

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class
abstract class Vehicless implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    public Vehicless(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

   
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
        System.out.println("Insurance: " + getInsuranceDetails());
        System.out.println("Rental Cost for " + days + " days: " + calculateRentalCost(days));
        System.out.println("Insurance Cost: " + calculateInsurance());
        System.out.println("------------------------------------");
    }

    // Encapsulation 
    public double getRentalRate() {
        return rentalRate;
    }

    protected String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public String getType() {
        return type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
}


class Cars extends Vehicless {
    public Cars(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; 
    }

    @Override
    public double calculateInsurance() {
        return 0.05 * getRentalRate();
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy " + getInsurancePolicyNumber() + " (Car)";
    }
}


class Bike extends Vehicless {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * getRentalRate();
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy " + getInsurancePolicyNumber() + " (Bike)";
    }
}


class Trucks extends Vehicless {
    public Trucks(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1500;
    }

    @Override
    public double calculateInsurance() {
        return 0.08 * getRentalRate(); 
    }

    @Override
    public String getInsuranceDetails() {
        return "Policy " + getInsurancePolicyNumber() + " (Truck)";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
      
        Vehicless car1 = new Cars("1234", 2000.0, "CAR123");
        Vehicless bike1 = new Bike("5678", 500.0, "BIKE456");
        Vehicless truck1 = new Trucks("9012", 3500.0, "TRUCK789");

       
        List<Vehicless> vehicleList = new ArrayList<>();
        vehicleList.add(car1);
        vehicleList.add(bike1);
        vehicleList.add(truck1);

  
        System.out.println("Vehicle Rental Details \n");
        for (Vehicless v : vehicleList) {
            v.displayDetails(3); 
        }
    }
}
