public class Product {
    private static double discount = 0.0;
    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails(Object obj) {
        if (obj instanceof Product) {
            Product product = (Product) obj;
            System.out.println("Product ID: " + product.productID);
            System.out.println("Product Name: " + product.productName);
            System.out.println("Price: " + product.price);
            System.out.println("Quantity: " + product.quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("Invalid product object.");
        }
    }

    public static void main(String[] args) {
        Product prod1 = new Product("Laptop", 1200.0, 2, "P1001");
        Product prod2 = new Product("Smartphone", 800.0, 3, "P1002");
        updateDiscount(10.0);
        prod1.displayProductDetails(prod1);
        System.out.println();
        prod2.displayProductDetails(prod2);
    }
}
