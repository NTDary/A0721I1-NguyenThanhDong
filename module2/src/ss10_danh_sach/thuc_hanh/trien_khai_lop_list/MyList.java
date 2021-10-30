package ss10_danh_sach.thuc_hanh.trien_khai_lop_list;
import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        //Check size = độ dài list thì tăng độ dài
        if (size == elements.length) {
            ensureCapa();
        }
        //add phần tử vào vị trí size
        elements[size++] = e;
    }
    public E get(int i) {
        if (i>= size || i <0) { // Ktra nếu vượt qua khuôn khổ size thì ném thông báo
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) elements[i];
    }
}
