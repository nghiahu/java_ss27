package presentation;

import business.BusinessCourse;
import entity.Course;
import util.validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseMenu {
    public static List<Course> courseList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean Exit = false;
        do {
            System.out.println("************************* COURSE MENU *************************");
            System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học theo ID");
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
                    BusinessCourse.displayCourse();
                    break;
                case 2:
                    BusinessCourse.addNewCourse(scanner);
                    break;
                case 3:
                    BusinessCourse.updateCourse(scanner);
                    break;
                case 4:
                    BusinessCourse.deleteCourse(scanner);
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
