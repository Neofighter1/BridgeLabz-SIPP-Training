
// Default Methods in Interfaces - Smart Vehicle Dashboard
interface VehicleDashboard {
    void displaySpeed();
    default void displayBattery() {
        System.out.println("Battery: 80%");
    }
}

class ElectricCar implements VehicleDashboard {
    public void displaySpeed() { System.out.println("Speed: 60 km/h"); }
}

public class SmartVehicleDashboard {
    public static void main(String[] args) {
        ElectricCar car = new ElectricCar();
        car.displaySpeed();
        car.displayBattery();
    }
}
