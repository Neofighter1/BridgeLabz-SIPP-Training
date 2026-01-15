package Level_1;
import java.util.*;
public class LibrarySystem {

    String title;
    String author;
    double price;
    boolean availability;

    LibrarySystem(String title,String author,double price,boolean availability){
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability= availability;
    }

    public void borrow(){
        if(availability){
            availability = false;
            System.out.println("The book is Borrowed.");
        }
        else{
            System.out.println("The book is not available");
        }
    }
    public void print(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + (availability ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of book");
        String title = sc.nextLine();
        System.out.println("Enter the author of book");
        String author = sc.nextLine();
        System.out.println("Enter the price of book");
        int price = sc.nextInt();

        LibrarySystem book = new LibrarySystem(title,author,price,true);
        System.out.println("The info of the book-");
        book.print();
        book.borrow();
    }

}