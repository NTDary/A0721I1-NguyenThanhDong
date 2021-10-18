package ss3_array_va_method.bai_tap;


public class test {
    public static void main(String[] args) {
        A a = new A();
        a.p(10);
        a.p(10.0);
    }
}

//class A extends B {
//    public void p(double number) {
//        System.out.println(number);
//    }
//}
//
//class B {
//    public void p(double number) {
//        System.out.println(number * 2);
//    }
//}

class A extends B {
    public void p(int number) {
        System.out.println(number);
    }
}

class B {
    public void p(double number) {
        System.out.println(number * 2);
    }
}