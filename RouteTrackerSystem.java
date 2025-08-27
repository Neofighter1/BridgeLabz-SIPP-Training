public class RouteTrackerSystem {
    public static abstract class Checkpoint {
        protected String checkpointId;
        protected String locationName;
        protected double distanceFromLast;
        protected double expectedDuration;
        protected double actualDuration;

        public Checkpoint(String checkpointId, String locationName, double distanceFromLast, double expectedDuration, double actualDuration) {
            this.checkpointId = checkpointId;
            this.locationName = locationName;
            this.distanceFromLast = distanceFromLast;
            this.expectedDuration = expectedDuration;
            this.actualDuration = actualDuration;
        }

        public String getCheckpointId() { return checkpointId; }
        public String getLocationName() { return locationName; }
        public double getDistanceFromLast() { return distanceFromLast; }
        public double getExpectedDuration() { return expectedDuration; }
        public double getActualDuration() { return actualDuration; }

        public abstract boolean isCritical();
        public abstract String getType();
        public abstract double calculatePenalty();

        public boolean isDelayed() {
            return actualDuration > expectedDuration;
        }
    }

    public static class DeliveryCheckpoint extends Checkpoint {
        public DeliveryCheckpoint(String checkpointId, String locationName, double distanceFromLast, double expectedDuration, double actualDuration) {
            super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
        }

        @Override
        public boolean isCritical() {
            return true;
        }

        @Override
        public String getType() {
            return "DeliveryCheckpoint";
        }

        @Override
        public double calculatePenalty() {
            if (isDelayed()) {
                return (actualDuration - expectedDuration) * 2;
            }
            return 0.0;
        }
    }

    public static class FuelCheckpoint extends Checkpoint {
        public FuelCheckpoint(String checkpointId, String locationName, double distanceFromLast, double expectedDuration, double actualDuration) {
            super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
        }

        @Override
        public boolean isCritical() {
            return true;
        }

        @Override
        public String getType() {
            return "FuelCheckpoint";
        }

        @Override
        public double calculatePenalty() {
            if (isDelayed()) {
                return 10.0;
            }
            return 0.0;
        }
    }

    public static class RestCheckpoint extends Checkpoint {
        public RestCheckpoint(String checkpointId, String locationName, double distanceFromLast, double expectedDuration, double actualDuration) {
            super(checkpointId, locationName, distanceFromLast, expectedDuration, actualDuration);
        }

        @Override
        public boolean isCritical() {
            return false;
        }

        @Override
        public String getType() {
            return "RestCheckpoint";
        }

        @Override
        public double calculatePenalty() {
            if (isDelayed() && (actualDuration - expectedDuration) > 30) {
                return (actualDuration - expectedDuration) * 0.5;
            }
            return 0.0;
        }
    }

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class RouteLinkedList<T extends Checkpoint> {
        private Node<T> head;

        public RouteLinkedList() {
            this.head = null;
        }

        public void addCheckpoint(T checkpoint) {
            Node<T> newNode = new Node<>(checkpoint);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public boolean removeCheckpoint(String checkpointId) {
            if (head == null) {
                return false;
            }
            if (head.data.getCheckpointId().equals(checkpointId)) {
                head = head.next;
                return true;
            }

            Node<T> current = head;
            Node<T> previous = null;
            while (current != null && !current.data.getCheckpointId().equals(checkpointId)) {
                previous = current;
                current = current.next;
            }

            if (current != null) {
                previous.next = current.next;
                return true;
            }
            return false;
        }

        public T findCheckpoint(String checkpointId) {
            Node<T> current = head;
            while (current != null) {
                if (current.data.getCheckpointId().equals(checkpointId)) {
                    return current.data;
                }
                current = current.next;
            }
            return null;
        }

        public double computeTotalDistance() {
            double totalDistance = 0.0;
            Node<T> current = head;
            while (current != null) {
                totalDistance += current.data.getDistanceFromLast();
                current = current.next;
            }
            return totalDistance;
        }

        public double computeTotalPenalty() {
            double totalPenalty = 0.0;
            Node<T> current = head;
            while (current != null) {
                totalPenalty += current.data.calculatePenalty();
                current = current.next;
            }
            return totalPenalty;
        }

        public void printRoute() {
            if (head == null) {
                System.out.println("Route is empty.");
                return;
            }
            Node<T> current = head;
            int count = 1;
            while (current != null) {
                String delayStatus = current.data.isDelayed() ? "Delayed" : "On Time";
                System.out.printf("%d. %s - %s - %s - Penalty: %.1f%n",
                        count,
                        current.data.getType(),
                        current.data.getLocationName(),
                        delayStatus,
                        current.data.calculatePenalty());
                current = current.next;
                count++;
            }
        }

        public boolean checkCriticalCheckpoints() {
            boolean hasDelivery = false;
            boolean hasFuel = false;

            Node<T> current = head;
            while (current != null) {
                if (current.data instanceof DeliveryCheckpoint) {
                    hasDelivery = true;
                } else if (current.data instanceof FuelCheckpoint) {
                    hasFuel = true;
                }
                current = current.next;
            }
            return hasDelivery && hasFuel;
        }
    }

    public static class Driver {
        private String driverId;
        private String name;
        private RouteLinkedList<Checkpoint> routeHistory;

        public Driver(String driverId, String name) {
            this.driverId = driverId;
            this.name = name;
            this.routeHistory = new RouteLinkedList<>();
        }

        public String getDriverId() { return driverId; }
        public String getName() { return name; }
        public RouteLinkedList<Checkpoint> getRouteHistory() { return routeHistory; }

        public void getRouteSummary() {
            System.out.println("Route Summary:");
            routeHistory.printRoute();
        }

        public double getTotalDistance() {
            return routeHistory.computeTotalDistance();
        }

        public double getTotalPenalty() {
            return routeHistory.computeTotalPenalty();
        }

        public double getRouteScore() {
            return getTotalDistance() - getTotalPenalty();
        }

        public String checkRouteConsistency() {
            if (routeHistory.checkCriticalCheckpoints()) {
                return "All required checkpoints present";
            } else {
                return "Missing some critical checkpoints";
            }
        }
    }

    public static void main(String[] args) {
        Driver driver = new Driver("D1204", "Kavita Nair");
        driver.getRouteHistory().addCheckpoint(new DeliveryCheckpoint("CP001", "Warehouse A", 20.0, 45.0, 60.0));
        driver.getRouteHistory().addCheckpoint(new FuelCheckpoint("CP002", "Fuel Station B", 15.0, 10.0, 12.0));
        driver.getRouteHistory().addCheckpoint(new RestCheckpoint("CP003", "Rest Area C", 25.0, 30.0, 35.0));

        System.out.println("Driver: " + driver.getName());
        System.out.println("Driver ID: " + driver.getDriverId());
        driver.getRouteSummary();
        System.out.println("Total Distance: " + driver.getTotalDistance() + " km");
        System.out.println("Total Penalty: " + driver.getTotalPenalty());
        System.out.println("Route Score: " + driver.getRouteScore());
        System.out.println("Route Consistency: " + driver.checkRouteConsistency());
    }
}
