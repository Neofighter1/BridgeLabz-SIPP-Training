import java.util.*;
interface Taxable {
	double calculateTax(double price);
	double getTaxDatails();
}
abstract class Products implements Taxable{
	private int productId;
	private String name;
	private double price;
	Products(int productId, String name, double price){
		this.productId=productId;
		this.name=name;
		this.price=price;
	}
	abstract double calculateDiscount();
	public void display() {
		System.out.println("ProductId: "+productId);
		System.out.println("Name: "+name);
		System.out.println("Base Price of product: "+price);
		System.out.println("Tax on product: "+getTaxDatails());
		System.out.println("Price after discount: "+calculateDiscount());
		System.out.println("Final Price: ₹" + calculateFinalPrice());
        System.out.println("-----------------------------");
	}
	
	public double calculateFinalPrice() {
	        return calculateDiscount() + getTaxDatails();
	    }
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
	
	
	
}
class Electronics extends Products{
	private double discount;
	private double tax;
	public Electronics(int productId,String name,double price,double discount,double tax) {
		super(productId,name, price);
		this.discount=discount;
		this.tax=tax;
	}
	@Override
	public double calculateDiscount() {
		return getPrice() - (getPrice()*discount)/100;
	}
	public double getTaxDatails() {
		
		return calculateTax(getPrice());
	}
	public double calculateTax(double price){
		return (tax*price)/100;
		}
	
	
	
}
class Clothing extends Products{
	private double discount;
	private double tax;
	public Clothing(int productId,String name,double price,double discount,double tax) {
		super(productId,name, price);
		this.discount=discount;
		this.tax=tax;
	}
	@Override
	public double calculateDiscount() {
		return getPrice() - (getPrice()*discount)/100;
	}
	public double getTaxDatails() {
		
		return calculateTax(getPrice());
	}
	public double calculateTax(double price){
		return (tax*price)/100;
		}
	
	
}
class Groceries extends Products{
	private double discount;
	private double tax;
	public Groceries(int productId,String name,double price,double discount,double tax) {
		super(productId,name, price);
		this.discount=discount;
		this.tax=tax;
	}
	@Override
	public double calculateDiscount() {
		return getPrice() - (getPrice()*discount)/100;
	}
	public double getTaxDatails() {
		
		return calculateTax(getPrice());
	}
	public double calculateTax(double price){
		return (tax*price)/100;
		}
	
	
	
}
public class E_commerce_Platform {

	public static void main(String[] args) {
		Products electronics = new Electronics(12,"One_Plus",30000.0,10,20);
		Products clothing = new Clothing(13,"T-Shirt",650.0,10,20);
		Products groceries = new Groceries(14,"Almond",40000.0,20,40);
		
		List<Products> products = new ArrayList<>();
		products.add(electronics);
		products.add(groceries);
		products.add(clothing);
		
		for(Products pr :products) {
			pr.display();
		}

	}

}
