package Linkedlist;

class LinkedList<T> {
    Node<T> head;
    Node<T> tail;

    void add(T data){
        Node<T>newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            newNode.next=head;
            head=newNode;
        }
    }
    void append(T data){
        Node<T>newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=head;
            tail=newNode;
        }
    }
    void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
}
