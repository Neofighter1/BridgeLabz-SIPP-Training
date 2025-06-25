public class Employee {
    private static String companyName = "Tech Solutions";
    private static int totalEmployees = 0;
    private final String id;
    private String name;
    private String designation;

    public Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayEmployeeDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + emp.name);
            System.out.println("ID: " + emp.id);
            System.out.println("Designation: " + emp.designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", "E123", "Developer");
        Employee emp2 = new Employee("Jane Smith", "E456", "Manager");
        emp1.displayEmployeeDetails(emp1);
        System.out.println();
        emp2.displayEmployeeDetails(emp2);
        System.out.println();
        displayTotalEmployees();
    }
}
