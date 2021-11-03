package ss10_danh_sach.bai_tap.trien_khai_arraylist;

import java.util.Arrays;
import java.util.ArrayList;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object myArray[];

    public MyList() {
        myArray = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        myArray = new Object[capacity];
    }

    //Returns the number of elements in this list.
    public int getSize() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= myArray.length)
            throw new IndexOutOfBoundsException
                    ("index " + index + " out of bounds");

    }

    public void ensureCapacity(int minCapacity) {
        if (getSize() == myArray.length) {
            int newSize = myArray.length + minCapacity;
            myArray = Arrays.copyOf(myArray, newSize);
        }
    }

    public boolean add(int index, E element) {
        if (index >= 0 || index <= size) {
            size++;
            ensureCapacity(5);
            //System.out.println("ab "+size);
            for (int i = size - 2; i >= index; i--) {
                myArray[i + 1] = myArray[i];
            }
            myArray[index] = element;
            return true;
        } else {
            return false;
        }
    }


    public E get(int index) {
        checkIndex(index);
        return (E) myArray[index];
    }

    public E remove(int index) {
        Object removeData = myArray[index];
        if (myArray[index] != null) {
            for (int i = index; i < myArray.length - 1; i++) {
                myArray[i] = myArray[i + 1];
            }
            myArray[size - 1] = null;
            size--;
            return (E) removeData;
        } else {
            throw new IndexOutOfBoundsException
                    ("index " + index + " is null");
        }

    }

    public MyList clone() {
        MyList<E> cloneMyArray = new MyList<>(myArray.length);
        for (E element : (E[]) myArray) {
            cloneMyArray.add(element);
        }
        return cloneMyArray;
    }

    public void add(E element) {
        size++;
        ensureCapacity(5);
        myArray[size - 1] = element;

    }
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (myArray[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }
    public boolean contains(E o) {
        for (E x : (E[]) myArray) {
            if (o.equals(x)) {
                return true;
            }
        }
        return false;
    }
    public void clear() {
        myArray =  new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void display() {
        for (Object x : myArray) {
            if (x != null) {
                System.out.println(x);
            }
        }
    }
}
