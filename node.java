public class node {
    int data;
    node next;
    node(int data){
        this.data=data;
    }
    void addfirst(int data){
        
    }
    public static void main(String args[]){
        node head=new node(10);
        node a=new node(20);
        head.next=a;
        while(head!=null){
            System.out.print(head.data+"->");
            head=head.next;
        }
        System.out.print("null");
        
    }
}
