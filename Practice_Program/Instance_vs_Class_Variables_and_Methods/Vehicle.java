package Instance_vs_Class_Variables_and_Methods;

public class Vehicle {


    String ownerName;
    String vehicleType;
    static double registrationFee = 1000.00;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee:" + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to" + registrationFee);
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Rahul", "Car");
        Vehicle vehicle2 = new Vehicle("Sneha", "Bike");
        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
        System.out.println("Upgrade registration fee to Rs 1500");
        Vehicle.updateRegistrationFee(1500.00);
        System.out.println();
        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
    }
}
