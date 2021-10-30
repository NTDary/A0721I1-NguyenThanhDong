package ss10_danh_sach.thuc_hanh.trien_khai_lop_list;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(1);//0
        listInteger.add(2);//1
        listInteger.add(3);//2
        listInteger.add(3);//3
        listInteger.add(4);//4


        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));

        listInteger.get(-1);
        System.out.println("element -1: " + listInteger.get(-1));
    }
}
