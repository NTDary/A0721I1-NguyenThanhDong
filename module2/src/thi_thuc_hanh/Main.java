package thi_thuc_hanh;

import on_tap.model.Validation;

import on_tap.util.NotFoundVehicelException;
import thi_thuc_hanh.model.ChinhHang;
import thi_thuc_hanh.model.DienThoai;
import thi_thuc_hanh.model.XachTay;
import thi_thuc_hanh.service.QuanLyDienThoai;


import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int CHINHHANG = 1;
    private static final int XACHTAY = 2;
    private static Scanner scanner = new Scanner(System.in);
    //private static DienThoai dienThoai = new DienThoai();
    private static QuanLyDienThoai quanLyDienThoai = new QuanLyDienThoai();

    public static void main(String[] args) {
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ ĐIỆN THOẠI--");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Thêm mới\n2. Xóa\n3. Xem danh sách điện thoại\n4. Tìm kiếm\n5. Thoát");
        System.out.println("Chọn chức năng");
        //int choice= Integer.parseInt(scanner.nextLine());
        int choice = checkIsNumber(0,5);
        switch (choice) {
            case 1:
                System.out.println("1. Thêm điện thoại chính hãng\n2. Thêm điện thoại xách tay");
                choice = checkIsNumber(0,2);
                switch (choice) {
                    case CHINHHANG:
                        create(CHINHHANG);
                        break;
                    case XACHTAY:
                        create(XACHTAY);
                        break;
                }
                break;
            case 2:
                delete();
                break;
            case 3:
                display();
                break;
//            case 4:
//                search();
//                break;
        }
        backToMainMenu();
    }
    private static int checkIsNumber(int numberA, int numberB){
        int choice = 0;
        String tmp = "";
        do {
            tmp = scanner.nextLine();
            if(Validation.isNumber(tmp)){
                choice = Integer.parseInt(tmp);
                if(choice <= numberA || choice > numberB)
                    System.out.println("Bạn nhập ngoài vùng menu, vui lòng nhập lại");
            }else{
                System.out.println("Bạn nhập không phải là số, vui lòng nhập vào là kiểu số");
            }
        } while (choice <= numberA || choice > numberB || !Validation.isNumber(tmp));
        return choice;
    }
    private static void backToMainMenu() {
        System.out.print("Do you to back to main menu (Y/N): ");
        String anwser = scanner.nextLine();
        if (anwser.equalsIgnoreCase("y")) displayMainMenu();
        else System.exit(0);
    }
    private static void create(int loaidienthoai) {

        System.out.print("Tên điện thoại: ");
        String tenDienThoai = scanner.nextLine();
        System.out.print("Giá bán: ");
        double giaBan = Double.parseDouble(scanner.nextLine());
        System.out.print("Số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhà sản xuất: ");
        String nhaSX = scanner.nextLine();

        switch (loaidienthoai) {
            case 1:
                System.out.print("Thời gian bảo hành: ");
                int thoigianBH = Integer.parseInt(scanner.nextLine());
                System.out.print("Phạm vi bảo hành: ");
                String phamviBH = scanner.nextLine();
                ChinhHang dienthoaiChinhHang = new ChinhHang(0,tenDienThoai,giaBan,soLuong,nhaSX,thoigianBH,phamviBH);
                quanLyDienThoai.addMobile(dienthoaiChinhHang);
                //csvHelper.write(xeTai, ConTantApp.PATH_XETAI,true);
                break;
            case 2:
                System.out.print("Quốc gia xách tay: ");
                String quocgiaXachTay = scanner.nextLine();
                System.out.print("Trạng thái: ");
                String trangThai = scanner.nextLine();
                XachTay dienthoaiXachTay = new XachTay(0,tenDienThoai,giaBan,soLuong,nhaSX,quocgiaXachTay,trangThai);
                quanLyDienThoai.addMobile(dienthoaiXachTay);
                //csvHelper.write(xeTai, ConTantApp.PATH_XETAI,true);
                break;
        }
        System.out.println("Created successful");
    }
    private static void delete(){
        System.out.print("Điền vào Id cần Xoá: ");
        int id= Integer.parseInt(scanner.nextLine());
        try {
            quanLyDienThoai.delete(id);
        } catch (NotFoundVehicelException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted successfull");
    }
    private static void display(){
        quanLyDienThoai.displayMobile();
    }
}
