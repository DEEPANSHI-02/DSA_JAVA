public class SinglyLinkedList {

    static Class Node {
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
    public void insertAthead(int data){

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
            newNode.next = null;
        }
        size++;
    }

    // INSERT AT POSITION (1-based indexing)
    public void insertAtPosition(int data, int position){
        
        if(position < 1 || position > size+1){
            System.out.println("insertion is not possible at this position")
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

    

    public static void main(String[] args){

    }
}