package ss11_stack_queue.bai_tap.kiem_tra_dau_ngoac;

import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Stack<Character> myStack = new Stack<>();
        String myStr = "s * (s – a) * (s – b * (s – c)";
        if(checkBracket(myStack, myStr)){
            System.out.println("Biểu thức sử dụng ĐÚNG dấu ngoặc");
        }else{
            System.out.println("Biểu thức sử dụng SAI dấu ngoặc");
        }

    }
    public static boolean checkBracket(Stack<Character> myStack, String myStr) {
        char[] arrs = myStr.toCharArray();
        for (int i = 0; i < arrs.length; i++) {
            if(arrs[i] == '('){
                myStack.push(arrs[i]);
            }else if(arrs[i] == ')'){
                if(myStack.empty()){
                    return false;
                }else {
                    myStack.pop();
                }
            }
        }
        if(!myStack.empty()){
            return false;
        }else {
            return true;
        }
    }
}
