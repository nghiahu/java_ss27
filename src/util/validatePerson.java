package util;

import entity.Person;
import entity.Student;
import entity.Teacher;
import presentation.StudentMenu;
import presentation.TearcherMenu;

import java.util.Scanner;

public class validatePerson {
    public static String validatePhone(Scanner scanner) throws Exception {
        System.out.print("Nhập vào số điện thoại: ");
        String phone = scanner.nextLine();
        String regex = "^(09|08|03|05)\\d{8}$";
        if(phone.isEmpty()){
            throw new Exception("Số điện thoại không được để trống");
        }
        if (!phone.matches(regex)){
            throw new Exception("Số điện thoại không đúng định dạng");
        }
        boolean found = false;
        for(Student student : StudentMenu.studentList){
            if(student.getPhone().equals(phone)){
                found = true;
                break;
            }
        }
        for (Teacher teacher : TearcherMenu.teacherList){
            if(teacher.getPhone().equals(phone)){
                found = true;
                break;
            }
        }
        if(found){
            throw new Exception("Số điện thoại đã tồn tại!");
        }else {
            return phone;
        }
    }
    public static String validateEmail(Scanner scanner) throws Exception {
        System.out.print("Nhập vào email: ");
        String email = scanner.nextLine();
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z.]+\\.[a-zA-Z]{2,6}$";
        if(email.isEmpty()){
            throw new Exception("Email không được để trống");
        }
        if (!email.matches(regex)){
            throw new Exception("Email không đúng định dạng");
        }
        boolean found = false;
        for(Student student : StudentMenu.studentList){
            if(student.getEmail().equals(email)){
                found = true;
                break;
            }
        }
        for (Teacher teacher : TearcherMenu.teacherList){
            if(teacher.getEmail().equals(email)){
                found = true;
                break;
            }
        }
        if(found){
            throw new Exception("Email đã tồn tại!");
        }else {
            return email;
        }
    }
    public static Person.Gender validateGender(Scanner scanner) {
        do{
            System.out.println("Chọn giới tính: ");
            System.out.println("1. MAIL");
            System.out.println("2. FEMAIL");
            System.out.println("3. OTHER");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    return Person.Gender.MALE;
                case 2:
                    return Person.Gender.FEMALE;
                case 3:
                    return Person.Gender.OTHER;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại");
            }
        }while (true);
    }
}
