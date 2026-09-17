// linked list with 2 references have 3 things => data, prev node, next node .

public class DoublyLinkedList {

    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insertAtHead(int data){
        Node newNode = new Node(data);

        if(head==null && tail==null){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void insertAtTail(int data){
        Node newNode = new Node(data);

        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        } else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void insertAtPosition(int data, int position){
        if(position < 1 || position > size+1){
            return;
        } if(position == 1){
            insertAtHead(data);
            return;
        } if(position == size + 1){
            insertAtTail(data);
            return;
        }

        // in between
        Node temp = head ;

        for(int i=1; i<=position-2; i++){
            temp = temp.next;
        }
        // now temp is at prev node;
        Node prevNode = temp;
        Node nextNode = prevNode.next;
        Node currentNode = new Node(data);

        currentNode.prev = prevNode;
        prevNode.next = currentNode;
        
        currentNode.next = nextNode;
        nextNode.prev = currentNode;

        size++; 
    }

    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printBack(){
        Node temp = tail;

        while(temp != null){
            System.out.print("->" + temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[]args){

        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(10);
        list.printList();

        list.insertAtHead(20);
        list.printList();

        list.insertAtHead(30);
        list.printList();

        list.insertAtTail(100);
        list.printList();

        list.insertAtTail(110);
        list.printList();

        list.insertAtTail(120);
        list.printList();

        list.insertAtPosition(5000, 3);
        list.printList();

        list.printBack();
    }
}