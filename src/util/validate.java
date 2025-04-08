package util;

import java.util.Scanner;

public class validate {
    public static double validateDouble(Scanner scanner, int min, String message) throws Exception {
        System.out.print(message);
        if(!scanner.hasNextDouble()){
            throw new NumberFormatException("Dữ liệu nhập vào không phải kiểu số thực, vui nhập lại!");
        } else if (scanner.nextDouble()<min) {
            throw new Exception("Dữ liệu nhập vào không hợp lệ, vui lòng nhập lại!");
        }else {
            return scanner.nextDouble();
        }
    }
    public static String validateString(Scanner scanner, int min, int max, String message) throws Exception {
        System.out.print(message);
        String validString = scanner.nextLine();
        if(validString.trim().isEmpty()){
            throw new Exception("Dữ liệu không được để trống!");
        }else if(validString.trim().length() < min || validString.trim().length() > max){
            throw new Exception("Độ dài dữ liệu không phù hợp, vui lòng nhập lại!");
        }else {
            return validString;
        }
    }
    public static boolean validateBoolean(Scanner scanner, String message) throws Exception {
        System.out.print(message);
        String validString = scanner.nextLine().trim().toLowerCase();
        if(!validString.equals("true") && !validString.equals("false")){
            throw new Exception("Dữ liệu không đúng định dạng vui lòng nhập lại!");
        }else {
            return Boolean.parseBoolean(validString);
        }
    }
}
