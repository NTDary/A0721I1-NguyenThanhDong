package ss10_danh_sach.bai_tap.trien_khai_linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList<Object> ll = new MyLinkedList<>();

//        ll.addFirst(11);
//        ll.addFirst(12);
//        ll.addFirst(13);

        ll.add(4, 9);
        ll.add(5, "ab");
        ll.add(6, 2);
        ll.add(3,22);
        //ll.addLast(12);
        //ll.remove("ab");

        for (int i = 0; i <= ll.size(); i++) {
            System.out.println("node: " + i + " data: " + ll.get(i));
        }
    }
}
