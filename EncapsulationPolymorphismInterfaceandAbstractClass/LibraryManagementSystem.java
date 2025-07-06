import java.util.*;

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName;
    private boolean isReserved;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    // Abstract method
    public abstract int getLoanDuration(); 

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Reserved: " + (isReserved ? "Yes, by " + borrowerName : "No"));
        System.out.println("----------------------------------");
    }

    
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            this.borrowerName = borrowerName;
            this.isReserved = true;
            System.out.println(title + " reserved successfully by " + borrowerName);
        } else {
            System.out.println(title + " is already reserved by " + this.borrowerName);
        }
    }

    public boolean checkAvailability() {
        return !isReserved;
    }

    // Getters (Encapsulation)
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    protected String getBorrowerName() {
        return borrowerName;
    }

    protected boolean isReserved() {
        return isReserved;
    }
}


class Books extends LibraryItem {
    public Books(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21; 
    }
}


class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; 
    }
}

class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; 
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        
        LibraryItem book1 = new Books("01", "abc", "anuj");
        LibraryItem mag1 = new Magazine("02", "def", "madhav");
        LibraryItem dvd1 = new DVD("03", "ghi", "Me");

        // sPolymorphism
        List<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(book1);
        libraryItems.add(mag1);
        libraryItems.add(dvd1);


        System.out.println(" Library Items\n");
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
        }

        System.out.println("\n Reservation Status\n");
        book1.reserveItem("Alice");
        dvd1.reserveItem("Bob");
        book1.reserveItem("Charlie");


        System.out.println("\n Updated Library Items \n");
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
        }
    }
}
