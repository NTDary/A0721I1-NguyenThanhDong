package repository.impl;

import model.MatBang;
import repository.IMatBangRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBangRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_MATBANG = "select * from quan_ly_mat_bang";
    private static final String CREATE_MATBANG_SQL = "INSERT INTO quan_ly_mat_bang" + "  (ma_mat_bang, dien_tich, trang_thai,so_tang,loai_van_phong," +
            "mo_ta,gia_thue,ngay_bat_dau,ngay_ket_thuc) VALUES " +
            " (?, ?, ?,?,?,?,?,?,?);";

    @Override
    public List<MatBang> selectAllMatBang() {
        List<MatBang> matBangList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = baseRepository.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_MATBANG);
            ResultSet resultSet = preparedStatement.executeQuery();
            MatBang matBang;
            while (resultSet.next()){
                matBang = new MatBang();
                matBang.setMa_mat_bang(resultSet.getString("ma_mat_bang"));
                matBang.setDien_tich(resultSet.getInt("dien_tich"));
                matBang.setTrang_thai(resultSet.getString("trang_thai"));
                matBang.setSo_tang(resultSet.getInt("so_tang"));
                matBang.setLoai_van_phong(resultSet.getString("loai_van_phong"));
                matBang.setMo_ta(resultSet.getString("mo_ta"));
                matBang.setGia_thue(resultSet.getDouble("gia_thue"));
                matBang.setNgay_bat_dau(resultSet.getString("ngay_bat_dau"));
                matBang.setNgay_ket_thuc(resultSet.getString("ngay_ket_thuc"));
                matBangList.add(matBang);
            }
            connection.commit();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return matBangList;
    }

    @Override
    public void createMatBangThue(MatBang matBang) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = baseRepository.getConnection();
            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(CREATE_MATBANG_SQL);
            pstmt.setString(1,matBang.getMa_mat_bang());
            pstmt.setInt(2,matBang.getDien_tich());
            pstmt.setString(3,matBang.getTrang_thai());
            pstmt.setInt(4,matBang.getSo_tang());
            pstmt.setString(5,matBang.getLoai_van_phong());
            pstmt.setString(6,matBang.getMo_ta());
            pstmt.setDouble(7,matBang.getGia_thue());
            pstmt.setString(8,matBang.getNgay_bat_dau());
            pstmt.setString(9,matBang.getNgay_ket_thuc());

            pstmt.execute();
            conn.commit();

        }catch (SQLException e){
            e.printStackTrace();
            conn.rollback();
        }

    }

}
