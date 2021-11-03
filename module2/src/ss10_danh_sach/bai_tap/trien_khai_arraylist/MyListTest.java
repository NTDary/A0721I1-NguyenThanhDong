package ss10_danh_sach.bai_tap.trien_khai_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();

        System.out.println("Before - Size: " + myList.getSize());
        myList.add(21);
        myList.add(22);
        myList.add(23);
        myList.add(24);

        myList.add(2, 55);

        //check index and element
        System.out.println("Method indexOf: " + myList.indexOf(11));
        System.out.println("Method contains: " + myList.contains(22));

        //Get
        System.out.println("Method Get: " + myList.get(0));

        //Remove
        myList.remove(0);

        //Clone
        MyList<Integer> clone = myList.clone();
        clone.add(1, 100);
        System.out.println("Clone");
        clone.display();

        //Clear
        myList.clear();
        System.out.println("After - Size: " + myList.getSize());

    }
}
