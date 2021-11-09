package ss10_danh_sach.bai_tap.trien_khai_linkedlist;

public class MyLinkedList<E> {
    private Node head = null;
    private Node tail = null;
    private int numNodes = 0;

    public MyLinkedList() {

    }

    public int size() {
        return numNodes;
    }

    public void add(int index, E element) {
        if (index == 0) {
            addFirst(element);
        } else if (index >= size()) {
            addLast(element);
        } else {
            Node current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next; //3
            current.next = new Node(element);
            current.next.next = temp;
            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head; // 2
        head = newNode; //1-2
        numNodes++;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode; //add note cuối
            tail = tail.next; // trỏ đến note cuối - tail(note cuối)
        }
        //head      tail    tail
        //1     2 3  4      5
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index > size()) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {
            Node pre = head;
            for (int i = 1; i < index; i++) {
                pre = pre.next;
            }
            Node current = pre.next;
            pre.next = current;
            numNodes--;

            return (E)current.getData();
        }
    }

    public E removeFirst() {
        if (size() == 0) return null; // Nothing to delete
        else {
            Node temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            numNodes--; // Reduce size by 1
            if (head == null) tail = null; // List becomes empty
            return (E) temp.getData(); // Return the deleted element
        }
    }

    public E removeLast() {
        if (size() == 0) {
            return null;
        } else if (size() == 1) {
            Node temp = head;
            head = head.next;
            numNodes--;
            return (E) temp.getData();
        } else {
            Node current = head;
            for (int i = 0; i < size() - 2; i++) {
                current = current.next;
            }
            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.getData();
        }
    }

    public boolean remove(Object e) {
        if(head.getData().equals(e)){
            removeFirst();
            return true;
        }else{
            Node temp = head;
            while (temp.next != null){
                if(temp.next.getData().equals(e)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        return temp.getData();
    }
    //Exception in thread "main" java.lang.NullPointerException:
    //Cannot invoke "ss10_danh_sach.bai_tap.trien_khai_linkedlist.Node.getData()" because "temp" is null
    //at ss10_danh_sach.bai_tap.trien_khai_linkedlist.MyLinkedList.get(MyLinkedList.java:130)
    //at ss10_danh_sach.bai_tap.trien_khai_linkedlist.MyLinkedListTest.main(MyLinkedListTest.java:19)
//

//
//    public E clone() {
//
//    }
//
//    public boolean remove(E o) {
//
//    }
//
//    public int indexOf(E o) {
//
//    }
//
//    public boolean add(E e) {
//
//    }
//
//    public void ensureCapacity(int minCapacity) {
//
//    }
//
//    public E get(int i) {
//
//    }
//
//    public E getFirst(int i) {
//
//    }
//
//    public E getLast(int i) {
//
//    }
//
//    public void clear() {
//
//    }
}
