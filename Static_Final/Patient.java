public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final String patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment, String patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayPatientDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient patient = (Patient) obj;
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Name: " + patient.name);
            System.out.println("Age: " + patient.age);
            System.out.println("Ailment: " + patient.ailment);
            System.out.println("Patient ID: " + patient.patientID);
        } else {
            System.out.println("Invalid patient object.");
        }
    }

    public static void main(String[] args) {
        Patient p1 = new Patient("Alice", 30, "Flu", "P001");
        Patient p2 = new Patient("Bob", 45, "Fracture", "P002");
        p1.displayPatientDetails(p1);
        System.out.println();
        p2.displayPatientDetails(p2);
        System.out.println();
        System.out.println("Total Patients: " + getTotalPatients());
    }
}
