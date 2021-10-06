package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number;
        String kq;
        String[] inputRay;

        do{
            System.out.printf("Fill in number: ");
            number = scanner.nextLine();
            inputRay = number.split("");

            switch (inputRay.length){
                case 1:
                    if(number.equals("0")){
                        System.out.println("zero");
                    }else{
                        System.out.println(tenDown(number));
                    }
                    break;
                case 2:
                    System.out.println(tenUp(inputRay[0], tenDown(inputRay[1])));
                    break;
                case 3:
                    if(Integer.parseInt(number) >= 100){
                        System.out.print(hunredUp(inputRay[0]));
                        System.out.print(" and "+tenUp(inputRay[1], tenDown(inputRay[2])));
                    }else{
                        System.out.println(tenUp(inputRay[1], tenDown(inputRay[2])));
                    }
                    break;

            }
        }while (Integer.parseInt(number) > 999 || Integer.parseInt(number) < 0);
    }

    private static String tenDown(String number) {
        switch (number) {
            case "0":
                return "";
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
            default:
                return "can't read this";
        }
    }

    private static String tenUp(String number, String previous) {
        switch (number) {
            case "0":
                return previous;
            case "1":
                switch (previous) {
                    case "":
                        return "ten";
                    case "one":
                        return "eleven";
                    case "two":
                        return "twelve";
                    case "three":
                        return "thirdteen";
                    default:
                        return previous + "teen";
                }
            case "2":
                return "twenty " + previous;
            case "3":
                return "thirdty " + previous;
            default:
                return tenDown(number) + "ty" + " " + previous;

        }
    }

    private static String hunredUp(String number) {
        return tenDown(number) + " hunred";
    }

}
