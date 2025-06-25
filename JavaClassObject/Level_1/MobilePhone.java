package Level_1;
import java.util.Scanner;

public class MobilePhone {

    String brand;
    String model;
    double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Brand: " + brand);
        
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter brand name: ");
        
        String brand = sc.nextLine();
        System.out.print("Enter model name: ");
        String model = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        MobilePhone phone = new MobilePhone(brand, model, price);
        phone.displayDetails();
        sc.close();
    }
}
