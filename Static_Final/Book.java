public class Book {
    private static String libraryName = "City Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
        } else {
            System.out.println("Invalid book object.");
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", "ISBN12345");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN67890");

        displayLibraryName();
        System.out.println();

        book1.displayBookDetails(book1);
        System.out.println();
        book2.displayBookDetails(book2);
    }
}
