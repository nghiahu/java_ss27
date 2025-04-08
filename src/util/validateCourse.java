package util;

import entity.Course;
import entity.Student;
import entity.Teacher;
import presentation.TearcherMenu;

import java.util.List;
import java.util.Scanner;

import static presentation.CourseMenu.courseList;

public class validateCourse {
    public static String validateId(Scanner scanner) throws Exception {
        System.out.print("Nhập vào Id khóa học: ");
        boolean found = false;
        String id = scanner.nextLine().trim();
        for(Course course : courseList){
            if (course.getCourseId().equals(id)){
                found = true;
                break;
            }
        }
        String regex = "^C\\d{4}$";
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
    public static String validateName(Scanner scanner, int min, int max) throws Exception {
        boolean found = false;
        System.out.print("Nhập vào tên khóa học: ");
        String name = scanner.nextLine().trim();
        for(Course course : courseList){
            if (course.getCourseName().equals(name)){
                found = true;
                break;
            }
        }
        if(name.isEmpty()){
            throw new Exception("Tên khóa học không được để trống, vui lòng nhập lại!");
        }else if(found){
            throw new Exception("Tên khóa học bị trùng, vui lòng nhập lại!");
        }else if(name.length()<min || name.length()>max){
            throw new Exception("Tên khóa học không phù hợp vui lòng nhập lại!");
        }else {
            return name;
        }
    }
    public static int validateTeacherId(Scanner scanner) throws Exception {
        boolean found = false;
        System.out.print("Nhập vào mã giảng viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Teacher teacher : TearcherMenu.teacherList){
            if(teacher.getTeacherId() == id){
                found = true;
                break;
            }
        }
        if(!found){
            throw new Exception("Không tìm thấy giảng viên");
        }else {
            return id;
        }
    }

}
