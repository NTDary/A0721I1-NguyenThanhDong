package ss11_stack_queue.bai_tap.dao_nguoc_phan_tu_use_stack;

public class ReverseInt {
    private int size;
    private int top;
    private int[] myStack;

    public static void main(String[] args) {
        ReverseInt reverse = new ReverseInt(5);


        //Ghi giá trị lần lượt 0 1 2 3 vào stack inter
        System.out.println("Mảng int chưa đảo ngược");
        for (int i = 0; i < 4; i++){
            reverse.push(i);
            System.out.print(i + " ");
        }
      System.out.println("\nMảng int sau khi đảo ngược");
        for (int i = 0; i < reverse.size-1; i++)
        {
            System.out.print(reverse.pop() + " ");
        }
    }

    public ReverseInt(int size){
        top = -1;
        this.size = size;
        myStack = new int[size];
    }
    public boolean isEmpty(){
        if(top < 0)
            return true;
        return false;
    }
    public boolean isFull(){
        if(top > size)
            return true;
        return false;
    }


    public boolean push(int value){
        if(top >= size){
            System.out.println("Stack Overflow");
            return false;
        }else{
            myStack[++top] = value;
            //System.out.println(top);
            return true;
        }
    }
    public int pop(){
        if(top < 0){
            System.out.println("Stack Underflow");
            return -1;
        }else{
            return myStack[top--];
        }
    }
}
