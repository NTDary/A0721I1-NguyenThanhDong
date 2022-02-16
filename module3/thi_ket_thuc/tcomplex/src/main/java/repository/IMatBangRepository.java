package repository;

import model.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface IMatBangRepository {
    List<MatBang> selectAllMatBang();
    public void createMatBangThue(MatBang matBang) throws SQLException;
}
