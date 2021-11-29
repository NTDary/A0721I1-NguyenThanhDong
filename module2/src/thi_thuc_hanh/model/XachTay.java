package thi_thuc_hanh.model;

public class XachTay extends DienThoai {
    private String quocGia;
    private String trangThai;

    public XachTay(String quocGia, String trangThai) {
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public XachTay(int id, String phoneName, double price, int quatity, String hangSanXuat, String quocGia, String trangThai) {
        super(id, phoneName, price, quatity, hangSanXuat);
        this.quocGia = quocGia;
        this.trangThai = trangThai;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return
                getId() +
                        "," + getPhoneName() +
                        "," + getPrice() +
                        "," + getQuatity() +
                        "," + getHangSanXuat() +
                        "," + quocGia +
                        "," + trangThai;
    }
}
