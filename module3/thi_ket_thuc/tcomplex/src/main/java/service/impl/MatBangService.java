package service.impl;

import model.MatBang;
import repository.IMatBangRepository;
import repository.impl.MatBangRepository;
import service.IMatBangService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class MatBangService implements IMatBangService {
    IMatBangRepository iMatBangRepository = new MatBangRepository();
    @Override
    public List<MatBang> selectAllMatBang() {
        return iMatBangRepository.selectAllMatBang();
    }

    @Override
    public HashMap<String, String> createMatBangThue(MatBang matBang) throws SQLException {
        HashMap<String, String> map = new HashMap<>();
        if(!matBang.getNgay_bat_dau().matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")){
            map.put("date","lỗi format date");
        }if(!matBang.getNgay_ket_thuc().matches("([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))")){
            map.put("date","lỗi format date");
        }
        if(map.isEmpty()){
            iMatBangRepository.createMatBangThue(matBang);
        }
        return map;
    }
}
