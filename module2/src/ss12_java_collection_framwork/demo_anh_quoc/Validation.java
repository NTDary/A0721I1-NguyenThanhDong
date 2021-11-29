package ss12_java_collection_framwork.demo_anh_quoc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String NUMBER_REX = "\\d";

    private static Pattern pattern;
    private static Matcher matcher;

    static boolean isNumber(String number) {
        pattern = Pattern.compile(NUMBER_REX);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }

//    boolean checkName(String name){
//        pattern= Pattern.compile("");
//        matcher= pattern.matcher(name);
//        return matcher.matches();
//    }
}
