package util;

import entity.Course;
import entity.Student;
import presentation.StudentMenu;

import java.util.Scanner;

import static presentation.CourseMenu.courseList;

public class validateStudent {
    public static String validateIdStudent(Scanner scanner) throws Exception {
        System.out.print("Nhập vào mã sinh viên: ");
        boolean found = false;
        String id = scanner.nextLine().trim();
        for(Student student : StudentMenu.studentList) {
            if (student.getStudentId().equals(id)) {
                found = true;
                break;
            }
        }
        String regex = "^SV\\d{3}$";
        if (id.isEmpty()){
            throw new Exception("Id không được để trống!");
        } else if (found) {
            throw new Exception("Id bị trùng lặp vui lòng nhập lại!");
        } else if (!id.matches(regex)) {
            throw new Exception("Id không đúng định dạng vui lòng nhập lại!");
        }else {
            return id;
        }
    }
}
