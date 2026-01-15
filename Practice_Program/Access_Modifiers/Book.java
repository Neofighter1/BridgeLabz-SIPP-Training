package Access_Modifiers;

 class Books {
 public String ISBN;         
 protected String title;       
 private String author;        

 
 public Books(String ISBN, String title, String author) {
     this.ISBN = ISBN;
     this.title = title;
     this.author = author;
 }

 
 public void setAuthor(String author) {
     this.author = author;
 }


 public String getAuthor() {
     return author;
 }
}


 class EBook extends Books {
 private double fileSize;
 //private String ebookAuthor;

 public EBook(String ISBN, String title, String author, double fileSize) {
     super(ISBN, title, author); // use as simple super key word
     
     // below the line use for with out super key word
//	 super("","","");
//	 Books object = new Books(ISBN,title,author);
//	 this.ISBN = object.ISBN;
//     this.title = object.title;
//     this.ebookAuthor = object.getAuthor();
//     this.fileSize = fileSize;
     // Override getter and setter to use local copy
 }
//     @Override
//     public String getAuthor() {
//         return ebookAuthor;
//     }
//
//     @Override
//     public void setAuthor(String author) {
//         this.ebookAuthor = author;
//     }

 

 
 public void showEBookDetails() {
     System.out.println("ISBN : " + ISBN);           
     System.out.println("Title : " + title);      
     System.out.println("Author : " + getAuthor()); 
     System.out.println("File Size: " + fileSize + " MB");
 }
}


public class Book {
 public static void main(String[] args) {
     EBook ebook = new EBook("123-123-123434", "Java", "Anuj Chaturvedi", 3.289);
     ebook.showEBookDetails();


     ebook.setAuthor("Hemant Kaushik");
     System.out.println("\nUpdated Author: " + ebook.getAuthor());
 }
}
