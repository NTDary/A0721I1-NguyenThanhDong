package ss11_stack_queue.bai_tap.dem_so_lan_xuat_hien_tu_use_map;

import java.util.LinkedHashMap;
import java.util.Map;

public class Count {


    public static void main(String[] args) {
        String myStr = "Lap Trinh CodeGym lap trinh cuoc song";
        System.out.println(myStr);
        System.out.println("---------------------------------------");
        System.out.println("Liệt kê số lần xuất hiện của các từ: ");

        Map<String, Integer> map = new LinkedHashMap<String,Integer>();
        countWord(map, myStr);
        for (String key : map.keySet()) {
            System.out.print(key + " " + map.get(key) + "\n");
        }

    }

    public static void countWord(Map<String, Integer> map, String str) {
        int size = str.length();
        if (size == 0) {
            return;
        } else {
            //Chuyen thanh mang String,Chuyen chu HOA thanh chu thuong
            String[] myStr1 = str.toLowerCase().split(" ");
            for (int i = 0; i < myStr1.length; i++) {
                if (map.containsKey(myStr1[i])) {
                    int count = map.get(myStr1[i]) + 1;
                    map.put(String.valueOf(myStr1[i]), count);
                }else {
                    map.put(String.valueOf(myStr1[i]), 1);
                }
            }
        }

    }
}
