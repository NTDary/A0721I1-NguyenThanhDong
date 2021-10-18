package ss4_class_object.bai_tap.stop_watch;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

//[Bài tập] Xây dựng lớp StopWatch
//Viết chương trình đo thời gian thực thi của thuật toán sắp xếp chọn (selection sort) cho 100,000 số.

public class Main {
    public static void main(String[] args) {
        //Khởi tạo đối tượng watch
        Watch watch = new Watch();

        //Bắt đầu thời gian
        watch.start();
        System.out.println("Thời gian bắt đầu:" + watch.getStartTime());

        //Tạo mảng 100.000 số ngẫu nhiên
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.floor(100000 * Math.random());
        }
        //Sort Mảng
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        //Kết thúc thời gian
        watch.stop();
        System.out.println("Thời gian kết thúc:" + watch.getEndTime());

        //Đo thời gian sau khi sắp xếp
        long elapsedtime = watch.getElapsedTime();
        System.out.println("Tổng thời gian: " + elapsedtime + " millisecond");
    }
}
