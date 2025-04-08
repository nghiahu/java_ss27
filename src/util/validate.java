package util;

import java.util.Scanner;

public class validate {
    public static int validateInt(Scanner scanner, int min, String message) throws Exception {
        System.out.print(message);
        if (!scanner.hasNextInt()) {
            throw new Exception("Dữ liệu nhập vào không phải số nguyên");
        }
        int n = Integer.parseInt(scanner.next());
        if (n < min) {
            throw new Exception("Dữ liệu không hợp lệ!");
        }else {
            return n;
        }
    }
    public static double validateDouble(Scanner scanner, int min, String message) throws Exception {
        System.out.print(message);
        if (!scanner.hasNextDouble()) {
            scanner.next();
            throw new Exception("Dữ liệu nhập vào không phải số thực");
        }
        double n = Double.parseDouble(scanner.next());
        if (n < min) {
            throw new Exception("Dữ liệu không hợp lệ!");
        }else {
            return n;
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
