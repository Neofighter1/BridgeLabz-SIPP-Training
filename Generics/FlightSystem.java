import java.util.*;
// Generic class for flights
class Flight<T>{
	private T flightNumber;
	private String departure;
	private String destination;
	public Flight(T flightNumber,String departure,String destination) {
		this.flightNumber=flightNumber;
		this.departure=departure;
		this.destination=destination;
	}
	public T getFlightNumber() {
		return flightNumber;
	}
	public void displayFlightInfo() {
		System.out.println("Flight: "+flightNumber +" | from: "+departure+ " | To : " +destination);
	}
}

//Generic class for Booking System.

class Booking<T>{
	private T bookingId;
	private Flight<?> flight;
	private String passengerName;
	public Booking(T bookingId,Flight<?> flight ,String passengerName) {
		this.bookingId=bookingId;
		this.flight=flight;
		this.passengerName = passengerName;
	}
	public void displayBookingInfo() {
		System.out.println("Booking Id: " +bookingId);
		System.out.println("passenger: "+ passengerName);
		flight.displayFlightInfo();
	}
}

//flight Management System with Bounded Types

class FlightManager<T extends Number>{
	private List<Flight<T>> flights = new ArrayList<>();
	public void addFlight(Flight<T> flight) {
		flights.add(flight);
	}
	public void displayAllFlights() {
		for(Flight<T> flight : flights) {
			flight.displayFlightInfo();
			
		}
	}
}

// Utility Methods with Wildcards
class FlightUtility{
	public static void displayFlightDetails(List<? extends Flight<?>> flights) {
		for(Flight<?> flight : flights) {
			flight.displayFlightInfo();
		}
	}
}
public class FlightSystem {
	
	public static void main(String[] args) {
		Flight<Integer> flight1 = new Flight<>(101,"New York","London");
		Flight<String > flight2 = new Flight<>("AA3o", "Delhi ","Mathura");
		Booking<Integer> booking1 = new Booking<>(5001, flight1, "John Doe");
        Booking<String> booking2 = new Booking<>("B102", flight2, "Jane Smith");
        
        booking1.displayBookingInfo();
        System.out.println("----------------");
        booking2.displayBookingInfo();
        
        System.out.println("\n--- Flight Management ---");
        FlightManager<Integer> manager = new FlightManager<>();
        manager.addFlight(flight1);
       // manager.addFlight(flight2);
        manager.displayAllFlights();

	}

}
