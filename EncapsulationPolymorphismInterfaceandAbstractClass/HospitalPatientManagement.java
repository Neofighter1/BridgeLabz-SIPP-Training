import java.util.*;

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

abstract class Patients implements MedicalRecord {
    private String patientId;
    private String name;
    private int age;
    private List<String> medicalHistory;

    public Patients(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Medical Records: " + viewRecords());
        System.out.println("Total Bill: ₹" + calculateBill());
        System.out.println("-----------------------------------");
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    public List<String> viewRecords() {
        return new ArrayList<>(medicalHistory);
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class InPatient extends Patients {
    private int numberOfDays;
    private double roomChargePerDay;
    private double treatmentCharges;

    public InPatient(String patientId, String name, int age, int numberOfDays, double roomChargePerDay, double treatmentCharges) {
        super(patientId, name, age);
        this.numberOfDays = numberOfDays;
        this.roomChargePerDay = roomChargePerDay;
        this.treatmentCharges = treatmentCharges;
    }

    public double calculateBill() {
        return numberOfDays * roomChargePerDay + treatmentCharges;
    }
}

class OutPatient extends Patients {
    private double consultationFee;
    private double testCharges;

    public OutPatient(String patientId, String name, int age, double consultationFee, double testCharges) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.testCharges = testCharges;
    }

    public double calculateBill() {
        return consultationFee + testCharges;
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patients p1 = new InPatient("1", "Me", 30, 5, 2000, 5000);
        Patients p2 = new OutPatient("2", "You", 45, 800, 1200);
        Patients p3 = new InPatient("3", "He", 50, 3, 2500, 4000);

        p1.addRecord("Admitted for surgery");
        p1.addRecord("Surgery successful");

        p2.addRecord("General checkup");
        p2.addRecord("Blood test done");

        p3.addRecord("Admitted for observation");

        List<Patients> patientList = new ArrayList<>();
        patientList.add(p1);
        patientList.add(p2);
        patientList.add(p3);

        System.out.println("Patient Billing Summary \n");
        for (Patients patients : patientList) {
            patients.getPatientDetails();
        }
    }
}
