import java.util.*;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem implements Discountable {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount Info: " + getDiscountDetails());
        System.out.println("Total Price after Discount: " + applyDiscount());
        System.out.println("-----------------------------------");
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class VegItem extends FoodItem {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        double total = calculateTotalPrice();
        return total - total * 0.10;
    }

    public String getDiscountDetails() {
        return "10% discount on veg items";
    }
}

class NonVegItem extends FoodItem {
    private double nonVegCharge = 30;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        return (getPrice() + nonVegCharge) * getQuantity();
    }

    public double applyDiscount() {
        double total = calculateTotalPrice();
        return total - total * 0.05;
    }

    public String getDiscountDetails() {
        return "5% discount on non-veg items + ₹30/item non-veg charge";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Paneer Masala", 220, 2);
        FoodItem item2 = new NonVegItem("Roti", 300, 1);
        FoodItem item3 = new VegItem("Dal", 150, 3);
        FoodItem item4 = new NonVegItem("Rice", 250, 2);

        List<FoodItem> order = new ArrayList<>();
        order.add(item1);
        order.add(item2);
        order.add(item3);
        order.add(item4);

        System.out.println(" Order Summary\n");
        for (FoodItem item : order) {
            item.getItemDetails();
        }
    }
}
