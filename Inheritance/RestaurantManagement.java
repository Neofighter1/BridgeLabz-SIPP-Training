

class PersonDetails{
	String name;
	String id;
	PersonDetails(String name, String id){
		this.name = name;
		this.id = id;
	}
}

interface Worker{
	void performDuties();
}

class Chef extends PersonDetails implements Worker{
	Chef(String name , String id){
		super(name,id);
	}
	public void performDuties(){
		System.out.println(name + " is a Chef in our restraurant with his id : "+id);
		System.out.println("Chef Duties : Cook dishes according to clients order");
	}
}

class Waiter extends PersonDetails implements Worker{
	Waiter(String name, String id){
		super(name, id);
	}
	public void performDuties() {
		System.out.println(name + " is a Waiter in our restraurant with his id : "+id);
		System.out.println("Waiter Duties : To take clients order and serve dishes accordingly");
	}
}

public class RestaurantManagement {
	public static void main(String[] args) {
		Chef chefObj = new Chef("abc","res123");
		Waiter waiterObj = new Waiter("xyz","res345");
		
		chefObj.performDuties();
		System.out.println();
		waiterObj.performDuties();
	}
}