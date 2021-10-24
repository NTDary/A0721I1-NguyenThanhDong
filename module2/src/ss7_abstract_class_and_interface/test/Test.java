package ss7_abstract_class_and_interface.test;

public class Test {
    public static void main(String[] args) {
        TruongPhong truongPhong = new TruongPhong("Dong",100000,250);
        truongPhong.xuat();
        System.out.println(truongPhong.luong);

    }
}
