package model;

public class MatBang {
    private String ma_mat_bang;
    private int dien_tich;
    private String trang_thai;
    private int so_tang;
    private String loai_van_phong;
    private String mo_ta;
    private Double gia_thue;
    private String ngay_bat_dau;
    private String ngay_ket_thuc;

    public MatBang(){}

    public MatBang(String ma_mat_bang, int dien_tich, String trang_thai, int so_tang, String loai_vang_phong, String mo_ta, Double gia_thue, String ngay_bat_dau, String ngay_ket_thuc) {
        this.ma_mat_bang = ma_mat_bang;
        this.dien_tich = dien_tich;
        this.trang_thai = trang_thai;
        this.so_tang = so_tang;
        this.loai_van_phong = loai_vang_phong;
        this.mo_ta = mo_ta;
        this.gia_thue = gia_thue;
        this.ngay_bat_dau = ngay_bat_dau;
        this.ngay_ket_thuc = ngay_ket_thuc;
    }

    public String getMa_mat_bang() {
        return ma_mat_bang;
    }

    public void setMa_mat_bang(String ma_mat_bang) {
        this.ma_mat_bang = ma_mat_bang;
    }

    public int getDien_tich() {
        return dien_tich;
    }

    public void setDien_tich(int dien_tich) {
        this.dien_tich = dien_tich;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getSo_tang() {
        return so_tang;
    }

    public void setSo_tang(int so_tang) {
        this.so_tang = so_tang;
    }

    public String getLoai_van_phong() {
        return loai_van_phong;
    }

    public void setLoai_van_phong(String loai_van_phong) {
        this.loai_van_phong = loai_van_phong;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public Double getGia_thue() {
        return gia_thue;
    }

    public void setGia_thue(Double gia_thue) {
        this.gia_thue = gia_thue;
    }

    public String getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(String ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public String getNgay_ket_thuc() {
        return ngay_ket_thuc;
    }

    public void setNgay_ket_thuc(String ngay_ket_thuc) {
        this.ngay_ket_thuc = ngay_ket_thuc;
    }
}
