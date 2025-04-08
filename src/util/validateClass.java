package util;

import entity.ClassRoom;
import entity.Course;
import entity.Person;
import presentation.ClassRoomMenu;

import java.util.Scanner;

import static presentation.CourseMenu.courseList;

public class validateClass {
    public static String validateClassName(Scanner scanner) throws Exception {
        System.out.println("Nhập vào tên lớp học: ");
        String className = scanner.nextLine();
        boolean found = false;
        for(ClassRoom classRoom : ClassRoomMenu.classRoomList){
            if (classRoom.getClassRoomName().equals(className)){
                found = true;
                break;
            }
        }
        if(className.isEmpty()){
            throw new Exception("Tên lớp học không được để trống, vui lòng nhập lại!");
        }else if(found){
            throw new Exception("Tên lớp học bị trùng, vui lòng nhập lại!");
        }else if(className.length()<15 || className.length()>50){
            throw new Exception("Tên khóa học không phù hợp vui lòng nhập lại!");
        }else {
            return className;
        }
    }

}
