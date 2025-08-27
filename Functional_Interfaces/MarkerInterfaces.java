
// Marker Interfaces Example
import java.io.Serializable;

interface BackupMarker {}
interface SensitiveData {}

class Student implements BackupMarker, Serializable {
    String name = "John";
}

class Prototype implements Cloneable {
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class BankDetails implements SensitiveData {
    String accountNumber = "123456789";
}

public class MarkerInterfaces {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        System.out.println("Student marked for backup.");

        Prototype p1 = new Prototype();
        Prototype p2 = (Prototype)p1.clone();
        System.out.println("Prototype cloned.");

        BankDetails bd = new BankDetails();
        System.out.println("BankDetails marked as sensitive.");
    }
}
