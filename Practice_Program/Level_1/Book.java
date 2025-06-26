package Level_1;

public class Book {
	String title;
	String author;
	int price;
	
	public Book() {
		title="Wings of Fire";
		author = "APJ";
		price= 120;
	}
	public Book(String title,String author,int price) {
		this.title =title;
		this.author= author;
		this.price= price;
	}
	public void display() {
		System.out.println("Book title : "+title);
		System.out.println("Book author : "+ author);
		System.out.println("Price of Book : "+price);
		
	}
	
	

	public static void main(String[] args) {
		System.out.println("Defult Constructor");
		Book defultconstructor = new Book();
		defultconstructor.display();
		System.out.println();
		System.out.println("Perameterize Constructor");
		Book peraconstructor = new Book("anuj", "mathura" , 3);
		peraconstructor.display();

		

	}

}

