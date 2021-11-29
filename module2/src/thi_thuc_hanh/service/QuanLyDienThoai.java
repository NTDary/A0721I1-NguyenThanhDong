package thi_thuc_hanh.service;


import on_tap.util.NotFoundVehicelException;

import thi_thuc_hanh.model.DienThoai;

import thi_thuc_hanh.util.Path;
import thi_thuc_hanh.util.ReadAndWriteFile;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDienThoai {
    List<DienThoai> dienThoais = new ArrayList<>();
    public void addMobile(DienThoai dienThoai) {
        if(dienThoai.getId() > 0){
            int index= dienThoais.indexOf(dienThoai);
            dienThoais.set(index, dienThoai);
        }else{
            dienThoai.setId(dienThoais.size() + 1);
            dienThoais.add(dienThoai);
        }
        ReadAndWriteFile.writeMobile(dienThoais, Path.MOBILES_PATH,true);

    }
    public void delete(int id) throws NotFoundVehicelException {
        List<DienThoai> listDienThoai = ReadAndWriteFile.getListDienThoai(Path.MOBILES_PATH);
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        for(int i=0; i < listDienThoai.size(); i++){
            if(listDienThoai.get(i).getId()  == id){
                System.out.println("Id có tồn tại bạn có muốn xóa? Y/N");
                String anwser = scanner.nextLine();
                //if (anwser.equalsIgnoreCase("y")) displayMainMenu();
               // else System.exit(0);
                listDienThoai.remove(i);
                ReadAndWriteFile.writeMobile(listDienThoai,Path.MOBILES_PATH,false);
                check = true;
                break;
            }
        }
        if(!check){
            throw new NotFoundVehicelException("Không tìm thấy.");
        }
    }

    public void displayMobile() {
        for (int i = 0; i < dienThoais.size(); i++) {
            System.out.println(dienThoais.get(i));
        }

    }
}
