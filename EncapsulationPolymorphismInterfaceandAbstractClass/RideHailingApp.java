import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehiclee implements GPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehiclee(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails(double distance) {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + getCurrentLocation());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: ₹" + calculateFare(distance));
        System.out.println("-----------------------------------");
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class car extends Vehiclee {
    public car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }
}

class Bike extends Vehiclee {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

class Auto extends Vehiclee {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehiclee v1 = new car("CAR123", "Rahul", 15.0, "MG Road");
        Vehiclee v2 = new Bike("BIKE456", "Amit", 8.0, "Brigade Road");
        Vehiclee v3 = new Auto("AUTO789", "Vikram", 10.0, "Indiranagar");

        v1.updateLocation("Koramangala");
        v2.updateLocation("BTM Layout");
        v3.updateLocation("HSR Layout");

        List<Vehiclee> rides = new ArrayList<>();
        rides.add(v1);
        rides.add(v2);
        rides.add(v3);

        System.out.println("=== Ride Fare Details ===\n");
        for (Vehiclee v : rides) {
            v.getVehicleDetails(12.5);
        }
    }
}
