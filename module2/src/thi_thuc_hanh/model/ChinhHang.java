package thi_thuc_hanh.model;

public class ChinhHang extends DienThoai {
    private int thoigianBH;
    private String phamviBH;

    public ChinhHang(int thoigianBH, String phamviBH) {
        this.thoigianBH = thoigianBH;
        this.phamviBH = phamviBH;
    }

    public ChinhHang(int id, String phoneName, double price, int quatity, String hangSanXuat, int thoigianBH, String phamviBH) {
        super(id, phoneName, price, quatity, hangSanXuat);
        this.thoigianBH = thoigianBH;
        this.phamviBH = phamviBH;
    }

    public int getThoigianBH() {
        return thoigianBH;
    }

    public String getPhamviBH() {
        return phamviBH;
    }

    public void setThoigianBH(int thoigianBH) {
        this.thoigianBH = thoigianBH;
    }

    public void setPhamviBH(String phamviBH) {
        this.phamviBH = phamviBH;
    }

    @Override
    public String toString() {
        return
                getId() +
                "," + getPhoneName() +
                "," + getPrice() +
                "," + getQuatity() +
                "," + getHangSanXuat() +
                "," + thoigianBH +
                "," + phamviBH;
    }

}
