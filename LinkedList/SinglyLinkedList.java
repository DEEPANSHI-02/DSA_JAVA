public class SinglyLinkedList {

    static class Node {
        int data;
        Node next;

        // constructore
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    //constructor 
    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // INSERTION 
    // iNSERT AT BEGINNING
    public void insertAtHead(int data){

        Node newNode = new Node(data);
        
        // if ll is empty -> head and tail ko newNode pr point kardo 
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        } else{
            newNode.next = head;
            head = newNode;
        }
        // increase the size by 1;
        size++;
    }

    // INSERT AT TAIL
    public void insertAtTail(int data){

        Node newNode = new Node(data);

        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // INSERT AT POSITION (1-based indexing)
    public void insertAtPosition(int data, int position){
        
        if(position < 1 || position > size+1){
            System.out.println("insertion is not possible at this position");
            return ;
        } 
        if(position == 1){
            insertAtHead(data);
            return;
        } 
        if(position == size + 1){
            insertAtTail(data);
            return;
        }

        // middle 
        Node prevNode = head;
        // moce prevNode by position - 2 steps to reach to the previous node of the destination location
        for(int i =1; i<= position-2; i++){
            prevNode = prevNode.next;
        }

        Node newNode = new Node(data);
        // update links
        newNode.next = prevNode.next;
        prevNode.next = newNode;

        size++;
    }

    // TRAVERSAL

    public void printList(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println();
    }

    // utility function
    
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int getHead(){

        if(head == null){
            return -1;
        } else{
            return head.data;
        }
    }

    public int getTail(){

        if(tail == null){
            return -1;
        } else{
            return tail.data;
        }
    }

    public void clear(){

    }

    public boolean search(int target){

        Node temp = head;
        while(temp != null){
            if(temp.data == target) {
                return true;
            }else {
                temp = temp.next;
            }
        }
        return false;
    }

    public static void main(String[] args){

        SinglyLinkedList list = new SinglyLinkedList();

        if(list.isEmpty()){
            System.out.println("List is empty");
        }

        System.out.println("size of LL: "+ list.getSize());

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

        list.insertAtPosition(22, 1);
        list.printList();

        list.insertAtPosition(200, 8);
        list.printList();

        list.insertAtPosition(500,5);
        list.printList();

        System.out.print("Found or not:" + list.search(700));
    }
}