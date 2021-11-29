package thi_thuc_hanh.model;

public class DienThoai {
    private int id;
    private String phoneName;
    private String hangSanXuat;
    private double price;
    private int quatity;

    public DienThoai(){

    }
    public DienThoai(int id, String phoneName, double price, int quatity, String hangSanXuat) {
        this.id = id;
        this.phoneName = phoneName;
        this.hangSanXuat = hangSanXuat;
        this.price = price;
        this.quatity = quatity;
    }

    public int getId() {
        return id;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public String getHangSanXuat() {
        return hangSanXuat;
    }

    public double getPrice() {
        return price;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString() {
        return
                id +
                "," + phoneName + '\'' +
                "," + price + '\'' +
                "," + quatity +
                "," + hangSanXuat ;

    }
}
