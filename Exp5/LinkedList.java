package Exp5;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head;
    public LinkedList(){
        this.head = null;
    }

    public void insertFront(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertBack(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void display(){
        if(head==null){
            System.out.println("No nodes are available");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.print(current.data+" -> ");
            current = current.next;
        }
        System.out.println("Null");
    }

    public void delete(int data){
        if(head==null){
            System.out.println("No node to delete");
            return;
        }
        if(head.data == data){
            head = head.next;
            return;
        }
        Node previous = null;
        Node current = head;
        while(current!=null && current.data!=data){
            previous = current;
            current = current.next;
        }
        if(current==null){
            System.out.println("Data not present.");
            return;
        }
        previous.next = current.next;
    }

    public void insertAt(int data,int position){
        if(position < 0){
            System.out.println("Invalid, negative position");
            return;
        }
        if(position==1){
            this.insertFront(data);
            return;
        }
        
        Node newNode = new Node(data);
        Node current = head;
        for(int i=0;i<position-2;i++){
            current = current.next;
            if(current==null){
                System.out.println("Position out of bounds.");
                return;
            }
        }
        if(current.next == null){
            current.next = newNode;
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public static void main(String arg[]){
        LinkedList ll = new LinkedList();
        ll.insertFront(1);
        ll.insertBack(3);
        ll.insertAt(2, 2);
        ll.insertAt(4,4);
        ll.display();
    }
}

