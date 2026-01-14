import java.util.*;
public class Queue_Using_Stack {
    Stack<Integer>st1=new Stack<>();
    Stack<Integer>st2=new Stack<>();
    public void enqueue(int x){
        st1.push(x);
    }
    public int dequeue(){
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        return st1.pop();
    }
    public static void main(String[] args) {
        Queue_Using_Stack st=new Queue_Using_Stack();
        st.enqueue(1);
        st.enqueue(15);
        st.enqueue(13);
        st.enqueue(19);
        System.out.println(st.dequeue());
        System.out.println(st.dequeue());
        System.out.println(st.dequeue());
    }
}
