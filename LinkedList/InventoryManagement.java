class ItemDetail{//this class works as a node of linked list
	String itemName;
	String itemId;
	int quantity;
	int price;
	ItemDetail next;
	ItemDetail(String itemName,String itemId,int quantity,int price){
		this.itemName = itemName;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
		this.next = null;
	}
}


public class InventoryManagement {

	ItemDetail head;
	ItemDetail tail;
	static int size;
	InventoryManagement(){//initially head and tail remain null for a empty linked list
		this.head = null;
		this.tail = null;
	}
	
	//function to add at beginning
	public void addAtBeginning(String itemName,String itemId,int quantity,int price) {
		ItemDetail newNode = new ItemDetail(itemName,itemId,quantity,price);
		if(head == null) {
			head = tail = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	//function to add at end
	public void addAtEnd(String itemName,String itemId,int quantity,int price) {
		ItemDetail newNode = new ItemDetail(itemName,itemId,quantity,price);
		if(tail == null) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	//function to add at specific position and k be that specific position
	public void addAtkPosition(String itemName,String itemId,int quantity,int price,int k) {
		ItemDetail newNode = new ItemDetail(itemName,itemId,quantity,price);
		if(k == 1) {
			addAtBeginning(itemName,itemId,quantity,price);
		}
		else if(k == size) {
			addAtEnd(itemName,itemId,quantity,price);
		}
		else {
			ItemDetail temp = head;
			while(k-- > 2) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
		
	}
	
	//function to delete or remove a item based on item Id
	public void deleteByItemId(String itemId) {
		ItemDetail curr = head;
		ItemDetail prev = null;
		if(head.itemId == itemId) {
			head = head.next;
		}
		else {
		while(curr.itemId != itemId){
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		}
		size--; 
	}
		
	//function to update quantity by item Id
	public void updateGrade(int quantity , String itemId) {
		ItemDetail temp = head;
		while(temp.itemId != itemId) {
			temp = temp.next;
		}
		temp.quantity = quantity;
	}
		
	//function to search an item by item Id or item name
		public void searchByItemId(String itemId , String itemName) {
			ItemDetail temp = head;
			int check = 0;
			while(temp!=null) {
				if(temp.itemId == itemId || temp.itemName == itemName ) {
					check = 1;
					System.out.println("Item Details :");
					System.out.println("________________________");
					System.out.println("Item Name :"+temp.itemName);
					System.out.println("Item Id :"+temp.itemId);
					System.out.println("Quantity :"+temp.quantity);
					System.out.println("Price :"+temp.price);
					System.out.println("________________________");
					break;
				}
				else {
					temp = temp.next;
				}
			}
			if(check != 1) {
				System.out.println("Item record with item Id  : "+itemId +" or item Name :"+itemName +" doesn't exist" );
			}
		}
		
		//function to return total value of inventory after calculation
		public long totalValue() {
			long sum = 0;
			ItemDetail temp = head;
			while(temp!=null) {
				int pro = 1;
				pro = temp.quantity*temp.price;
				sum += pro;	
			}
			return sum;
		}
		
		//function to sort inventory based on price in descending order
		public void sortByPrice() {
			ItemDetail temp = head;
			while(temp.next!=null) {
				if(temp.price > temp.next.price) {
					ItemDetail a = temp;
					temp = temp.next;
					temp.next = a;
				}
			}
		}
	
		//function to display all items in inventory
		public void displayAll() {
			ItemDetail temp = head;
			while(temp!=null) {
				System.out.println("----Item Record----");
				System.out.println("Item Id :"+temp.itemId);
				System.out.println("Item Name :"+temp.itemName);
				System.out.println("Item Price :"+temp.price);
				System.out.println("Item Quanity Availabe :"+temp.quantity);
				System.out.println("_________________");	
				temp = temp.next;
			}
		}
		
	public static void main(String[] args) {
		InventoryManagement ll = new InventoryManagement();
		ll.addAtBeginning("Milk", "SMART12", 10, 60);
		ll.addAtEnd("Almond", "SMART15", 20, 250);
		ll.addAtkPosition("Bread", "SMART32", 15, 20, 2);
		ll.searchByItemId("SMART12", "Milk");
		ll.deleteByItemId("SMART12");
		ll.searchByItemId("SMART12", "Milk");
		ll.displayAll();
		long val = ll.totalValue();
		System.out.println("Total value of Inventory is :"+val);
		ll.sortByPrice();
		ll.displayAll();

	}
	
}