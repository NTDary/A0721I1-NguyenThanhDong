package ss11_stack_queue.bai_tap.dao_nguoc_phan_tu_use_stack;


public class ReverseChar {
    private int size;
    private int top;
    private char[] myStack;

    public static void main(String[] args) {
        ReverseChar reverse = new ReverseChar(5);


        String myStr = "Hello";
        String myStr1 = "";
        System.out.println("Mảng trước khi đảo ngược");
        System.out.println(myStr);
        for (int i = 0; i < myStr.length(); i++) {
            reverse.push(myStr.charAt(i));
        }
        System.out.println("Mảng sau khi đảo ngược");

        for (int i = 0; i < reverse.size; i++)
        {
            myStr1 += reverse.pop();
        }
        System.out.println(myStr1);



    }

    public ReverseChar(int size) {
        top = -1;
        this.size = size;
        myStack = new char[size];
    }

    public boolean isEmpty() {
        if (top < 0)
            return true;
        return false;
    }
    public int getSize(){
        return size;
    }
    public boolean isFull() {
        if (top > size)
            return true;
        return false;
    }

    public boolean push(char value) {
        if (top >= size) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            myStack[++top] = value;
            //System.out.println(top);
            return true;
        }
    }

    public char pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return (char) -1;
        } else {
            char x = myStack[top--];
            return x;
        }
    }
}
