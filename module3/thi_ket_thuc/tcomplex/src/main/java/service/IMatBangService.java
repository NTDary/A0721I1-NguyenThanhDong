package service;

import model.MatBang;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface IMatBangService {
    List<MatBang> selectAllMatBang();
    public HashMap<String, String> createMatBangThue(MatBang matBang) throws SQLException;
}
