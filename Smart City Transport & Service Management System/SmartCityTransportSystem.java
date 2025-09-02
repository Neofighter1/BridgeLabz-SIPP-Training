import java.time.LocalTime;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

// Functional Interface fare calculation ke liye
@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance, String serviceType);
}

// Marker Interface emergency services ke liye
interface EmergencyService {
}

// Interface with static aur default methods
interface TransportService {
    String getServiceType();
    String getRoute();
    LocalTime getDepartureTime();
    double getFare();
    boolean isAvailable();
    
    // Default method
    default void printServiceDetails() {
        System.out.println(getServiceType() + " - " + getRoute() + " - " + getDepartureTime() + 
                          " - ₹" + getFare() + " - " + (isAvailable() ? "Available" : "Not Available"));
    }
    
    // Static method
    static String getSystemInfo() {
        return "Smart City Transport Management System v1.0";
    }
}

// Utility interface static methods ke saath
interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Simple distance calculation (in km)
        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;
        return Math.sqrt(deltaLat * deltaLat + deltaLon * deltaLon) * 111; // Approximate km per degree
    }
}

// Transport Service ke implementations
class BusService implements TransportService {
    private String route;
    private LocalTime departureTime;
    private double fare;
    private boolean available;
    
    public BusService(String route, LocalTime departureTime, double fare, boolean available) {
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
        this.available = available;
    }
    
    @Override
    public String getServiceType() { return "Bus"; }
    
    @Override
    public String getRoute() { return route; }
    
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    
    @Override
    public double getFare() { return fare; }
    
    @Override
    public boolean isAvailable() { return available; }
}

class MetroService implements TransportService {
    private String route;
    private LocalTime departureTime;
    private double fare;
    private boolean available;
    
    public MetroService(String route, LocalTime departureTime, double fare, boolean available) {
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
        this.available = available;
    }
    
    @Override
    public String getServiceType() { return "Metro"; }
    
    @Override
    public String getRoute() { return route; }
    
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    
    @Override
    public double getFare() { return fare; }
    
    @Override
    public boolean isAvailable() { return available; }
}

class TaxiService implements TransportService {
    private String route;
    private LocalTime departureTime;
    private double fare;
    private boolean available;
    
    public TaxiService(String route, LocalTime departureTime, double fare, boolean available) {
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
        this.available = available;
    }
    
    @Override
    public String getServiceType() { return "Taxi"; }
    
    @Override
    public String getRoute() { return route; }
    
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    
    @Override
    public double getFare() { return fare; }
    
    @Override
    public boolean isAvailable() { return available; }
}

// Emergency Service ka implementation
class AmbulanceService implements TransportService, EmergencyService {
    private String route;
    private LocalTime departureTime;
    private double fare;
    private boolean available;
    
    public AmbulanceService(String route, LocalTime departureTime, double fare, boolean available) {
        this.route = route;
        this.departureTime = departureTime;
        this.fare = fare;
        this.available = available;
    }
    
    @Override
    public String getServiceType() { return "Ambulance"; }
    
    @Override
    public String getRoute() { return route; }
    
    @Override
    public LocalTime getDepartureTime() { return departureTime; }
    
    @Override
    public double getFare() { return fare; }
    
    @Override
    public boolean isAvailable() { return available; }
    
    @Override
    public void printServiceDetails() {
        System.out.println("EMERGENCY: " + getServiceType() + " - " + getRoute() + " - " + getDepartureTime() + " - FREE");
    }
}

// Passenger ka Data Class
class Passenger {
    private String name;
    private String route;
    private LocalTime travelTime;
    private double farePaid;
    private String serviceType;
    
    public Passenger(String name, String route, LocalTime travelTime, double farePaid, String serviceType) {
        this.name = name;
        this.route = route;
        this.travelTime = travelTime;
        this.farePaid = farePaid;
        this.serviceType = serviceType;
    }
    
    // Getters
    public String getName() { return name; }
    public String getRoute() { return route; }
    public LocalTime getTravelTime() { return travelTime; }
    public double getFarePaid() { return farePaid; }
    public String getServiceType() { return serviceType; }
    
    public boolean isPeakTime() {
        int hour = travelTime.getHour();
        return (hour >= 7 && hour <= 10) || (hour >= 17 && hour <= 20);
    }
}

// Main Smart City Transport System
public class SmartCityTransportSystem {
    private List<TransportService> services;
    private List<Passenger> passengers;
    
    public SmartCityTransportSystem() {
        this.services = new ArrayList<>();
        this.passengers = new ArrayList<>();
        initializeServices();
        initializePassengers();
    }
    
    private void initializeServices() {
        // Bus Services
        services.add(new BusService("Connaught Place to IGI Airport", LocalTime.of(8, 30), 250.00, true));
        services.add(new BusService("Pune Station to Hinjewadi IT Park", LocalTime.of(9, 15), 120.00, true));
        services.add(new BusService("Mumbai Central to Bandra", LocalTime.of(10, 45), 150.00, false));
        
        // Metro Services
        services.add(new MetroService("Delhi Metro: Red Line", LocalTime.of(8, 45), 60.00, true));
        services.add(new MetroService("Kolkata Metro: North-South", LocalTime.of(9, 30), 40.00, true));
        services.add(new MetroService("Bangalore Metro: Purple Line", LocalTime.of(11, 00), 80.00, true));
        
        // Taxi Services
        services.add(new TaxiService("Ola: Gurgaon to Delhi", LocalTime.of(8, 15), 850.00, true));
        services.add(new TaxiService("Uber: Andheri to Powai", LocalTime.of(9, 45), 650.00, true));
        services.add(new TaxiService("Local Taxi: Hyderabad City", LocalTime.of(10, 30), 750.00, false));
        
        // Emergency Service
        services.add(new AmbulanceService("Emergency: AIIMS to Home", LocalTime.of(8, 00), 0.00, true));
    }
    
    private void initializePassengers() {
        passengers.add(new Passenger("Rahul Sharma", "Connaught Place to IGI Airport", LocalTime.of(8, 30), 250.00, "Bus"));
        passengers.add(new Passenger("Priya Singh", "Delhi Metro: Red Line", LocalTime.of(8, 45), 60.00, "Metro"));
        passengers.add(new Passenger("Amit Kumar", "Ola: Gurgaon to Delhi", LocalTime.of(8, 15), 850.00, "Taxi"));
        passengers.add(new Passenger("Sneha Patel", "Pune Station to Hinjewadi IT Park", LocalTime.of(9, 15), 120.00, "Bus"));
        passengers.add(new Passenger("Vikash Gupta", "Kolkata Metro: North-South", LocalTime.of(9, 30), 40.00, "Metro"));
        passengers.add(new Passenger("Neha Agarwal", "Connaught Place to IGI Airport", LocalTime.of(18, 30), 250.00, "Bus"));
        passengers.add(new Passenger("Ravi Verma", "Delhi Metro: Red Line", LocalTime.of(19, 15), 60.00, "Metro"));
        passengers.add(new Passenger("Pooja Jain", "Uber: Andheri to Powai", LocalTime.of(17, 45), 650.00, "Taxi"));
    }
    
    // 1. Lambda Expressions - Filtering aur Sorting
    public void filterAndSortServices() {
        System.out.println("1. LAMBDA EXPRESSIONS - Filtering aur Sorting");
        System.out.println("----------------------------------------------");
        
        // Available services ko filter karo aur fare ke hisab se sort karo (lowest first)
        System.out.println("Available Services (sorted by lowest fare):");
        services.stream()
            .filter(service -> service.isAvailable()) // Lambda expression
            .sorted((s1, s2) -> Double.compare(s1.getFare(), s2.getFare())) // Lambda expression
            .forEach(TransportService::printServiceDetails);
        
        System.out.println();
    }
    
    // 2. Method References
    public void demonstrateMethodReferences() {
        System.out.println("2. METHOD REFERENCES");
        System.out.println("--------------------");
        
        System.out.println("Printing all services using method reference:");
        services.forEach(TransportService::printServiceDetails); // Method reference
        
        System.out.println("\nUsing static method reference:");
        System.out.println("System Info: " + TransportService.getSystemInfo());
        
        System.out.println("\nPrinting passenger names using method reference:");
        passengers.forEach(passenger -> System.out.println("Passenger: " + passenger.getName()));
        
        System.out.println();
    }
    
    private double calculateStandardFare(double distance, String serviceType) {
        switch (serviceType.toLowerCase()) {
            case "bus": return distance * 1.5;
            case "metro": return distance * 2.0;
            case "taxi": return distance * 3.5;
            default: return distance * 2.0;
        }
    }
    
    // 3. Default Methods ka demonstration
    public void demonstrateDefaultMethods() {
        System.out.println("3. DEFAULT METHODS");
        System.out.println("------------------");
        System.out.println("Using default printServiceDetails() method from interface:");
        services.stream()
            .limit(3)
            .forEach(TransportService::printServiceDetails);
        System.out.println();
    }
    
    // 4. Static Methods ka demonstration
    public void demonstrateStaticMethods() {
        System.out.println("4. STATIC METHODS");
        System.out.println("-----------------");
        
        double distance = GeoUtils.calculateDistance(28.6139, 77.2090, 19.0760, 72.8777);
        System.out.println("Distance between Delhi and Mumbai: " + String.format("%.2f", distance) + " km");
        System.out.println("System Info: " + TransportService.getSystemInfo());
        System.out.println();
    }
    
    // 5. Stream APIs - Grouping aur Aggregating
    public void demonstrateStreamAPIs() {
        System.out.println("5. STREAM APIs");
        System.out.println("--------------");
        
        // Group passengers by service type
        Map<String, Long> passengerCount = passengers.stream()
            .collect(Collectors.groupingBy(Passenger::getServiceType, Collectors.counting()));
        
        System.out.println("Passengers by service type:");
        passengerCount.forEach((service, count) -> 
            System.out.println(service + ": " + count + " passengers"));
        
        // Calculate total revenue
        double totalRevenue = passengers.stream()
            .mapToDouble(Passenger::getFarePaid)
            .sum();
        System.out.println("Total Revenue: ₹" + String.format("%.2f", totalRevenue));
        System.out.println();
    }
    
    // 6. ForEach Method - Live Dashboard
    public void displayLiveDashboard() {
        System.out.println("6. FOREACH METHOD - Live Dashboard");
        System.out.println("----------------------------------");
        System.out.println("Active Services:");
        
        services.stream()
            .filter(TransportService::isAvailable)
            .forEach(service -> System.out.println("- " + service.getServiceType() + 
                    " on " + service.getRoute()));
        
        System.out.println();
    }
    
    // 7. Collectors - Advanced Usage
    public void demonstrateCollectors() {
        System.out.println("7. COLLECTORS");
        System.out.println("-------------");
        
        // Peak time ke hisab se partitioning
        Map<Boolean, List<Passenger>> peakTimePartition = passengers.stream()
            .collect(Collectors.partitioningBy(Passenger::isPeakTime));
        
        System.out.println("Peak time passengers: " + peakTimePartition.get(true).size());
        System.out.println("Non-peak time passengers: " + peakTimePartition.get(false).size());
        
        // Fare statistics ko summarize karna
        DoubleSummaryStatistics fareStats = passengers.stream()
            .collect(Collectors.summarizingDouble(Passenger::getFarePaid));
        
        System.out.println("Average fare: ₹" + String.format("%.2f", fareStats.getAverage()));
        System.out.println("Highest fare: ₹" + String.format("%.2f", fareStats.getMax()));
        System.out.println();
    }
    
    // 8. Marker Interfaces - Emergency Detection
    public void handleEmergencyServices() {
        System.out.println("8. MARKER INTERFACES");
        System.out.println("--------------------");
        
        long emergencyCount = services.stream()
            .filter(service -> service instanceof EmergencyService)
            .count();
        
        System.out.println("Emergency services available: " + emergencyCount);
        if (emergencyCount > 0) {
            System.out.println("Emergency services detected:");
            services.stream()
                .filter(service -> service instanceof EmergencyService)
                .forEach(TransportService::printServiceDetails);
        }
        System.out.println();
    }
    
    // 9. Functional Interfaces with Lambdas
    public void demonstrateFunctionalInterfaces() {
        System.out.println("9. FUNCTIONAL INTERFACES");
        System.out.println("------------------------");
        
        // Different fare calculation strategies using lambdas
        FareCalculator standardCalculator = (distance, serviceType) -> distance * 2.0;
        FareCalculator premiumCalculator = (distance, serviceType) -> distance * 3.5;
        
        double testDistance = 10.0;
        System.out.println("Fare calculations for " + testDistance + "km:");
        System.out.println("Standard: ₹" + String.format("%.2f", standardCalculator.calculateFare(testDistance, "Bus")));
        System.out.println("Premium: ₹" + String.format("%.2f", premiumCalculator.calculateFare(testDistance, "Taxi")));
        System.out.println();
    }
    
    // Real-time usage simulation
    public void simulateRealTimeUsage() {
        System.out.println("10. REAL-TIME SYSTEM DEMONSTRATION");
        System.out.println("----------------------------------");
        
        // Passenger booking
        System.out.println("Available services for booking:");
        services.stream()
            .filter(TransportService::isAvailable)
            .filter(service -> service.getFare() <= 120.0)
            .limit(3)
            .forEach(service -> System.out.println("- " + service.getServiceType() + 
                    " to " + service.getRoute() + " (₹" + service.getFare() + ")"));
        
        // Total revenue
        double totalRevenue = passengers.stream()
            .mapToDouble(Passenger::getFarePaid)
            .sum();
        System.out.println("Total Revenue: ₹" + String.format("%.2f", totalRevenue));
        
        // Adding new service (Ferry)
        System.out.println("Adding new Ferry Service:");
        TransportService ferryService = new TransportService() {
            @Override
            public String getServiceType() { return "Ferry"; }
            @Override
            public String getRoute() { return "Harbor-Island"; }
            @Override
            public LocalTime getDepartureTime() { return LocalTime.of(10, 15); }
            @Override
            public double getFare() { return 120.00; }
            @Override
            public boolean isAvailable() { return true; }
        };
        ferryService.printServiceDetails();
        System.out.println();
    }
    
    public static void main(String[] args) {
        SmartCityTransportSystem system = new SmartCityTransportSystem();
        
        System.out.println("SMART CITY TRANSPORT MANAGEMENT SYSTEM");
        System.out.println("=====================================");
        System.out.println("Demonstrating Java 8 Features");
        System.out.println();
        
        // Demonstrate all Java 8 features
        system.filterAndSortServices();           // 1. Lambda Expressions
        system.demonstrateMethodReferences();     // 2. Method References
        system.demonstrateDefaultMethods();       // 3. Default Methods
        system.demonstrateStaticMethods();        // 4. Static Methods
        system.demonstrateStreamAPIs();           // 5. Stream APIs
        system.displayLiveDashboard();            // 6. ForEach Method
        system.demonstrateCollectors();           // 7. Collectors
        system.handleEmergencyServices();         // 8. Marker Interfaces
        system.demonstrateFunctionalInterfaces(); // 9. Functional Interfaces
        system.simulateRealTimeUsage();           // 10. Real-time simulation
        
        System.out.println("System demonstration complete!");
    }
}
