package presentation;

import business.BusinessRegistration;
import entity.CourseRegistration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationMenu {
    public static List<CourseRegistration> courseRegistrationList = new ArrayList<CourseRegistration>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean Exit = false;
        do {
            System.out.println("*******************COURSE REGISTRATION MENU*****************");
            System.out.println("1. Đăng ký khóa học cho sinh viên");
            System.out.println("2. Hủy đăng ký học cho sinh viên");
            System.out.println("3. Duyệt đăng ký học sinh viên");
            System.out.println("4. Xem danh sách sinh viên đăng ký từtừng khóa học");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    BusinessRegistration.addNewRegistration(scanner);
                    break;
                case 2:
                    BusinessRegistration.unsubscribe(scanner);
                    break;
                case 3:
                    BusinessRegistration.subscribe(scanner);
                    break;
                case 4:
                    BusinessRegistration.displayRegistration();
                    break;
                case 5:
                    Exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 - 5");
            }
        }while (!Exit);
    }
}
