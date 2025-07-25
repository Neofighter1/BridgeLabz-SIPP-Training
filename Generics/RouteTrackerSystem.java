import java.util.*;

 abstract class Checkpoint {
 protected String checkpointId;
 protected String locationName;
 protected double distanceFromLast; 
 protected int expectedDuration;    
 protected int actualDuration;      

 public Checkpoint(String checkpointId, String locationName, double distanceFromLast,
                   int expectedDuration, int actualDuration) {
     this.checkpointId = checkpointId;
     this.locationName = locationName;
     this.distanceFromLast = distanceFromLast;
     this.expectedDuration = expectedDuration;
     this.actualDuration = actualDuration;
 }

 public String getCheckpointId() { return checkpointId; }
 public String getLocationName() { return locationName; }
 public double getDistanceFromLast() { return distanceFromLast; }

 public boolean isDelayed() {
     return actualDuration > expectedDuration;
 }

 public int getDelay() {
     return actualDuration - expectedDuration;
 }

 public abstract String getType();
 public abstract boolean isCritical();
 public abstract double calculatePenalty();

 @Override
 public String toString() {
     return getType() + " – " + locationName;
 }
}

class DeliveryCheckpoint extends Checkpoint {
 public DeliveryCheckpoint(String id, String name, double dist, int exp, int act) {
     super(id, name, dist, exp, act);
 }

 @Override
 public String getType() { return "DeliveryCheckpoint"; }

 @Override
 public boolean isCritical() { return true; }

 @Override
 public double calculatePenalty() {
     if (isDelayed()) {
         return getDelay() * 2.0;
     }
     return 0.0;
 }
}

class FuelCheckpoint extends Checkpoint {
 public FuelCheckpoint(String id, String name, double dist, int exp, int act) {
     super(id, name, dist, exp, act);
 }

 @Override
 public String getType() { return "FuelCheckpoint"; }

 @Override
 public boolean isCritical() { return true; }

 @Override
 public double calculatePenalty() {
     if (isDelayed()) {
         return 10.0;
     }
     return 0.0;
 }
}

class RestCheckpoint extends Checkpoint {
 public RestCheckpoint(String id, String name, double dist, int exp, int act) {
     super(id, name, dist, exp, act);
 }

 @Override
 public String getType() { return "RestCheckpoint"; }

 @Override
 public boolean isCritical() { return false; }

 @Override
 public double calculatePenalty() {
     if (isDelayed() && getDelay() > 30) {
         return getDelay() * 0.5;
     }
     return 0.0;
 }
}


class RouteLinkedList<T extends Checkpoint> {
 private class Node {
     T checkpoint;
     Node next;
     Node(T checkpoint) {
         this.checkpoint = checkpoint;
     }
 }

 private Node head;

 public void addCheckpoint(T checkpoint) {
     Node newNode = new Node(checkpoint);
     if (head == null) {
         head = newNode;
     } else {
         Node temp = head;
         while (temp.next != null) temp = temp.next;
         temp.next = newNode;
     }
 }

 public boolean removeCheckpoint(String checkpointId) {
     if (head == null) return false;
     if (head.checkpoint.getCheckpointId().equals(checkpointId)) {
         head = head.next;
         return true;
     }
     Node temp = head;
     while (temp.next != null) {
         if (temp.next.checkpoint.getCheckpointId().equals(checkpointId)) {
             temp.next = temp.next.next;
             return true;
         }
         temp = temp.next;
     }
     return false;
 }

 public T findCheckpoint(String checkpointId) {
     Node temp = head;
     while (temp != null) {
         if (temp.checkpoint.getCheckpointId().equals(checkpointId)) {
             return temp.checkpoint;
         }
         temp = temp.next;
     }
     return null;
 }

 public double computeTotalDistance() {
     double total = 0;
     Node temp = head;
     while (temp != null) {
         total += temp.checkpoint.getDistanceFromLast();
         temp = temp.next;
     }
     return total;
 }

 public double computeTotalPenalty() {
     double total = 0;
     Node temp = head;
     while (temp != null) {
         total += temp.checkpoint.calculatePenalty();
         temp = temp.next;
     }
     return total;
 }

 public void printRoute() {
     Node temp = head;
     int index = 1;
     while (temp != null) {
         Checkpoint cp = temp.checkpoint;
         System.out.println(index + ". " + cp.getType() + " – " + cp.getLocationName() +
                 " – " + (cp.isDelayed() ? "Delayed" : "On Time") +
                 " – Penalty: " + cp.calculatePenalty());
         temp = temp.next;
         index++;
     }
 }

 public boolean checkCritical() {
     boolean deliveryFound = false;
     boolean fuelFound = false;
     Node temp = head;
     while (temp != null) {
         if (temp.checkpoint instanceof DeliveryCheckpoint) deliveryFound = true;
         if (temp.checkpoint instanceof FuelCheckpoint) fuelFound = true;
         temp = temp.next;
     }
     return deliveryFound && fuelFound;
 }
}


class Driver {
 private String driverId;
 private String name;
 private RouteLinkedList<Checkpoint> routeHistory;

 public Driver(String driverId, String name) {
     this.driverId = driverId;
     this.name = name;
     this.routeHistory = new RouteLinkedList<>();
 }

 public void addCheckpoint(Checkpoint cp) {
     routeHistory.addCheckpoint(cp);
 }

 public void printSummary() {
     System.out.println("Driver: " + driverId + " – " + name);
     System.out.println("Route Summary:");
     routeHistory.printRoute();

     double totalDist = routeHistory.computeTotalDistance();
     double totalPenalty = routeHistory.computeTotalPenalty();
     double routeScore = totalDist - totalPenalty;

     System.out.println("Total Distance: " + totalDist + " km");
     System.out.println("Total Penalty: " + totalPenalty);
     System.out.println("Route Score: " + routeScore);
     System.out.println("Critical Route Check: " +
             (routeHistory.checkCritical() ? "All required checkpoints present" : "Missing critical checkpoints"));
 }
}


public class RouteTrackerSystem {
 public static void main(String[] args) {
     Driver d1 = new Driver("D1204", "Kavita Nair");

     d1.addCheckpoint(new DeliveryCheckpoint("C1", "Warehouse A", 30, 60, 70));
     d1.addCheckpoint(new FuelCheckpoint("C2", "Pump 12", 40, 20, 20));
     d1.addCheckpoint(new RestCheckpoint("C3", "Motel X", 20, 30, 35));
     d1.addCheckpoint(new DeliveryCheckpoint("C4", "Client Hub", 30, 90, 105));

     d1.printSummary();
 }
}