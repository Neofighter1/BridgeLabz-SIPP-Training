import java.util.*;
public class QueueUsingStacks {
	Stack<Integer> st1= new Stack<>();
	Stack<Integer> st2 =new Stack<>();
	
	public void enqueue(int data) {
		st1.push(data);
	}
	public int dequeue() {
		if(isEmpty()) {
			System.out.print("Queue is empty");
			
		}
		if(st2.isEmpty()) {
			while(!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
		return st2.pop();
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.print("Queue is empty");
			
		}
		if(st2.isEmpty()) {
			while(!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
		return st2.peek();
	}
	public boolean isEmpty() {
		return st1.isEmpty() && st2.isEmpty();
	}
	public static void main(String[] args) {
		   QueueUsingStacks q = new QueueUsingStacks();

	        q.enqueue(10);
	        q.enqueue(20);
	        q.enqueue(30);
	        System.out.println("Dequeued: " + q.dequeue()); 
	        System.out.println("Front: " + q.peek());       
	        q.enqueue(40);
	        System.out.println("Dequeued: " + q.dequeue());
	        System.out.println("Dequeued: " + q.dequeue());
	        System.out.println("Dequeued: " + q.dequeue());
	}

}
