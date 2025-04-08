package presentation;

import business.BusinessStudent;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    public static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean Exit = false;
        do {
            System.out.println("************************* STUDENT MENU *************************");
            System.out.println("1. Danh sách sinh viên được sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
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
                    BusinessStudent.displayStudent();
                    break;
                case 2:
                    BusinessStudent.addNewStudent(scanner);
                    break;
                case 3:
                    BusinessStudent.updateTeacher(scanner);
                    break;
                case 4:
                    BusinessStudent.deleteStudent(scanner);
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
