package Level_1;
import java.util.Scanner;

public class Item {
    int itemCode;
    String itemName;
    double price;

   public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Code: " + itemCode);
        System.out.println("Name: " + itemName);
        System.out.println("Price: " + price);
    }

    double totalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter item code: ");
        int code = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        Item item = new Item(code, name, price);
        item.displayDetails();
        System.out.println("Total Cost: " + item.totalCost(quantity));
        sc.close();
    }
}
