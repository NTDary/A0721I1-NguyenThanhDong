package ss5_access_modifier_static.bai_tap.xay_dung_class_chi_ghi;

 public class Student {
    private String name = "Join";
    private String classes = "C02";
    static String test = "a";

    Student(){}

    public void setName(String name){
        this.name = name;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }

}
