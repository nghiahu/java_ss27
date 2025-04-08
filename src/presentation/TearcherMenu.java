package presentation;

import entity.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TearcherMenu {
    public static List<Teacher> teacherList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean Exit = false;
        do {
            System.out.println("*************************TEACHER MENU**************************");
            System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
