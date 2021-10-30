package ss10_danh_sach.thuc_hanh.linkedlist_don_gian;

import org.w3c.dom.Node;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);

//        ll.addFirst(11);
//        ll.addFirst(12);
//        ll.addFirst(13);

        ll.add(4, 9);
        ll.add(5, 8);
//        ll.add(4,9);
        ll.printList();
        for (int i = 0; i <= ll.size(); i++) {
            System.out.println("node: " + i + " data: " + ll.get(i));
        }

    }
}
