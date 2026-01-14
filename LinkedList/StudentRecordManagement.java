class StudentDetail{//it will work as Node of a linkedList with student details
	String name;
	int rollNo;
	int age;
	char grade;
	StudentDetail next;
	StudentDetail(String name , int rollNo , int age , char grade){//constructor
		this.name = name;
		this.rollNo = rollNo;
		this.age = age;
		this.grade = grade;
		this.next = null;
	}
}

public class StudentRecordManagement {//main class
	
	StudentDetail head;
	StudentDetail tail;
	static int size;
	StudentRecordManagement(){//initially head and tail remain null for a empty linkedlist
		this.head = null;
		this.tail = null;
	}
	
	//function to add at beginning
	public void addAtBeginning(String name,int rollNo, int age, char grade) {
		StudentDetail newNode = new StudentDetail(name,rollNo,age,grade);
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
	public void addAtEnd(String name,int rollNo, int age, char grade) {
		StudentDetail newNode = new StudentDetail(name,rollNo,age,grade);
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
	public void addAtkPosition(String name,int rollNo, int age, char grade,int k) {
		StudentDetail newNode = new StudentDetail(name,rollNo,age,grade);
		if(k == 1) {
			addAtBeginning(name,rollNo,age,grade);
		}
		else if(k == size) {
			addAtEnd(name,rollNo,age,grade);
		}
		else {
			StudentDetail temp = head;
			while(k-- > 2) {
				temp = temp.next;
			}
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
		
	}
	
	//function to delete student record by roll number
	public void deleteByRollNo(int rollNo) {
		StudentDetail curr = head;
		StudentDetail prev = null;
		while(curr.rollNo != rollNo){
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		size--; 
	}
	
	//function to search student record by roll number
	public void searchByRollNo(int rollNo) {
		StudentDetail temp = head;
		int check = 0;
		while(temp!=null) {
			if(temp.rollNo == rollNo) {
				check = 1;
				System.out.println("Record of roll no. :"+ rollNo +":");
				System.out.println("________________________");
				System.out.println("Name :"+temp.name);
				System.out.println("Age :"+temp.age);
				System.out.println("Grade :"+temp.grade);
				System.out.println("________________________");
				break;
			}
			else {
				temp = temp.next;
			}
		}
		if(check != 1) {
			System.out.println("Student record with roll no : "+rollNo +" doesn't exist" );
		}
		
	}
	
	//function to display all students record
	public void displayAll() {
		StudentDetail temp = head;
		while(temp!=null) {
			System.out.println("-----Student Record-----");
			System.out.println("Name : "+temp.name);
			System.out.println("rollNo : "+temp.rollNo);
			System.out.println("Age : "+temp.age);
			System.out.println("Grade : "+temp.grade);
			System.out.println("________________________");
			temp = temp.next;
		}
	}
	
	//function to upgrade a student grade based on their rollNo
	public void updateGrade(char grade , int rollNo) {
		StudentDetail temp = head;
		while(temp.rollNo != rollNo) {
			temp = temp.next;
		}
		temp.grade = grade;
	}
		
	
	public static void main(String[] args) {
		StudentRecordManagement records = new StudentRecordManagement();
		records.addAtBeginning("Anuj", 1, 20, 'A');
		records.addAtEnd("Shivam", 32, 20, 'B');
		records.addAtEnd("Hemant", 20, 21, 'B');
		records.addAtkPosition("Dhruv", 12, 20, 'C', 2);
		System.out.println("Before updation : -----");
		records.searchByRollNo(12);
		records.updateGrade('B', 12);
		System.out.println("After updation : -----");
		records.searchByRollNo(12);
		System.out.println("Before Deletion : -----");
     	records.displayAll();
		records.deleteByRollNo(32);
		System.out.println("After deletion of a record : -----");
		records.displayAll();
	}

}