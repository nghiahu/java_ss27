package business;

import entity.ClassRoom;
import entity.Course;
import presentation.ClassRoomMenu;
import presentation.CourseMenu;
import util.validate;
import util.validateCourse;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static presentation.ClassRoomMenu.classRoomList;

public class BusinessCourse {
    public static void addNewCourse(Scanner scanner) {
        Course course = new Course();
        course.inputData(scanner);
        CourseMenu.courseList.add(course);
    }
    public static void displayCourse() {
        List<Course> courseListByName = CourseMenu.courseList.stream().sorted(Comparator.comparing(Course::getCourseName)).toList();
        if (!courseListByName.isEmpty()) {
            for (Course course : courseListByName) {
                course.displayCourse();
            }
        }else {
            System.out.println("Chưa có khóa học nào!");
        }
    }
    public static void updateCourse(Scanner scanner) {
        System.out.print("Nhập vào mã khóa học muốn sửa: ");
        String IdCourse = scanner.nextLine();
        boolean found = false;
        for (Course course : CourseMenu.courseList) {
            if (course.getCourseId().equals(IdCourse)) {
                found = true;
                boolean Exit = false;
                do {
                System.out.println("*************************MENU UPDATE COURSE *************************");
                System.out.println("1. Sửa tên khóa học");
                System.out.println("2. Sửa trạng thái khóa học");
                System.out.println("3. Thoát");
                System.out.print("Lựa chọn: ");
                int choice = 0;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
                switch (choice) {
                    case 1:
                        while (true) {
                            try {
                                course.setCourseName(validateCourse.validateName(scanner, 20, 100));
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            try {
                                course.setStatus(validate.validateBoolean(scanner,"Nhập vào trạng thái khóa học: "));
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case 3:
                        Exit = true;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại!");
                }
                }while (!Exit);
                break;
            }
        }
        if (found) {
            System.out.println("Cập nhập thàn công");
        }else {
            System.out.println("Không tìm thấy khóa học!");
        }
    }
    public static void deleteCourse(Scanner scanner) {
        System.out.print("Nhập vào mã khóa học muốn xóa: ");
        String IdCourse = scanner.nextLine();
        boolean found = false;
        boolean isClass = false;
        for (Course course : CourseMenu.courseList) {
            if (course.getCourseId().equals(IdCourse)) {
                found = true;
                break;
            }
        }
        for(ClassRoom classRoom : ClassRoomMenu.classRoomList){
            if (classRoom.getCourseId().equals(IdCourse)) {
                isClass = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy khóa học!");
        } else if (isClass) {
            System.out.println("Đã tồn tại lớp học không thể xóa");
        }else {
            CourseMenu.courseList.removeIf(course -> course.getCourseId().equals(IdCourse));
            System.out.println("Xóa thành công!");
        }
    }
}
