// package BridgeLabz;

public class stack {
    int top,cap;
    int []arr;
    public stack(){
        this.cap=1;
        top=-1;
        arr=new int[cap];
    }
    public void resize() {
        cap = 2 * cap;
        int[] newArr = new int[cap];
        for(int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public boolean push (int x){
        if(top>=cap-1){
            System.out.println("Overflow resizing");
            resize();
        }
        arr[++top]=x;
        return true;
    }
    public int pop(){
        if(top<0){
            System.out.println("Underflow");
            return -1;
        }
        return arr[top--];
    }
    public int peek(){
        if(top<0){
            System.out.println("Empty");
            return 0;
        }
        return arr[top];
    }
    public boolean isEmpty(){
        return top<0;
    }
    public static void main(String[] args) {
        stack a=new stack();
        a.push(10);
        a.push(20);
        a.push(30);
        a.push(40);
        a.push(50);
        System.out.println(a.peek());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.isEmpty());
    }
}
