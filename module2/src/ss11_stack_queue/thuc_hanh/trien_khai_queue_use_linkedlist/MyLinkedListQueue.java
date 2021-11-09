package ss11_stack_queue.thuc_hanh.trien_khai_queue_use_linkedlist;

public class MyLinkedListQueue {
    private Node head;
    private Node tail;


    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;

    }
    public void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) { //neu chua co phan tu => tro head va tail den note(data)
            this.head = this.tail = temp;

            return;
        }
        this.tail.next = temp;
        this.tail = temp;


    }
    public Node dequeue() {
        if (this.head == null)
            return null;
        Node temp = this.head;
        this.head = this.head.next;

        if (this.head == null)
            this.tail = null;
        return temp;
    }

    public void show(){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.key);
            temp = temp.next;
        }
//       for(int i=0; i <= size(); i++){
//           System.out.println(temp.key);
//           temp = temp.next;
//       }
    }
}
