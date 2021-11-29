package thi_thuc_hanh.util;

import demo_anh_chanh.model.Student;
import on_tap.model.Oto;
import on_tap.model.XeMay;
import on_tap.model.XeTai;
import thi_thuc_hanh.model.ChinhHang;
import thi_thuc_hanh.model.DienThoai;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<String> read(String path) {
        List<String> res = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists())
                file.createNewFile();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static List<DienThoai> getListDienThoai(String path) {
        List<String> listStr = read(path);
        List<DienThoai> listDienThoai = new ArrayList<>();

        for (int i = 0; i < listStr.size(); i++) {
            String[] array = listStr.get(i).split(",");

            DienThoai dienthoai = new DienThoai(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]),Integer.parseInt(array[3]),array[4]);
            listDienThoai.add(dienthoai);
        }
        return listDienThoai;
    }


    private static void write(List<String> tList, String path, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append));) {
            for (String e : tList) {
                bufferedWriter.write(e);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeMobile(List<DienThoai> listDienThoai, String path, boolean append) {
        List<String> listStr = new ArrayList<>();
        for (int i = 0; i < listDienThoai.size(); i++) {
            listStr.add(listDienThoai.get(i).toString());
        }
        write(listStr, path, append);
    }

}

