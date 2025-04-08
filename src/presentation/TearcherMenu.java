package presentation;

import business.BusinessTeacher;
import entity.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TearcherMenu {
    public static List<Teacher> teacherList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
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
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case 1:
                    BusinessTeacher.displayCourse();
                    break;
                case 2:
                    BusinessTeacher.addNewTeacher(scanner);
                    break;
                case 3:
                    BusinessTeacher.updateTeacher(scanner);
                    break;
                case 4:
                    BusinessTeacher.deleteTeacher(scanner);
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
