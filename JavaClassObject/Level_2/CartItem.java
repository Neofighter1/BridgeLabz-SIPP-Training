package Level_2;
import java.util.Scanner;

public class CartItem {

    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int qty) {
        quantity += qty;
    }

    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        } else {
            System.out.println("Cannot remove more than existing quantity.");
        }
    }

    double getTotalCost() {
        return price * quantity;
    }

    void display() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + getTotalCost());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter item name: ");
        
        String name = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        
        System.out.print("Enter item quantity: ");
        int qty = sc.nextInt();

         CartItem item = new CartItem(name, price, qty);
        System.out.println("Enter amount of item to add: " );
        item.addItem(sc.nextInt());
        System.out.println("Enter amount of item to remove: " );

        item.removeItem(sc.nextInt());
        item.display();
        sc.close();
    }
}
