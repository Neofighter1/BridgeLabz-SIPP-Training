package Level_1;

public class Hotel_Booking {
	String guestName ;
	String roomType ;
	int nights;

	public Hotel_Booking() {
		guestName ="Anuj";
		roomType = "Non-ac, without bathroom";
		nights =2;
	}
	public Hotel_Booking(String guestName, String roomType,int nights) {
		this.guestName=guestName;
		this.roomType=roomType;
		this.nights= nights;
	}
	public Hotel_Booking(Hotel_Booking h) {
		this.guestName=h.guestName;
		this.roomType=h.roomType;
		this.nights= h.nights;
	}
	public void display() {
		System.out.println("Guest Name : "+guestName);
		System.out.println("roomType : "+ roomType);
		System.out.println("Nights : "+nights);
		
	}

	public static void main(String[] args) {
		
		System.out.println("Defult Constructor");
		Hotel_Booking obj1 = new Hotel_Booking();
		obj1.display();
		System.out.println();
		System.out.println("Perameterize Constructor");
		Hotel_Booking obj2 = new Hotel_Booking("madhav","ac_room",3);
		obj2.display();

		System.out.println();

		System.out.println("Copy Constructor");
		Hotel_Booking obj3 = new Hotel_Booking(obj2);
		
		obj3.display();



	}

}
