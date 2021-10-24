package ss7_abstract_class_and_interface.test;

public class TruongPhong extends NhanVien {
    public double trachNhiem;

    public TruongPhong(String hoTen, double luong,double trachNhiem) {
        super(hoTen, luong);
        this.trachNhiem = trachNhiem;
    }

//    public TruongPhong(String hoTen, double luong, double trachNhiem) {
//
//    }

    public void xuat() {
        super.hoTen = "Tuấn";
        super.luong = 500;
        super.xuat();
       // double thuNhap = getThuNhap();
    }
}
