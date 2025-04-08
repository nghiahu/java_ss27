package business;

import entity.CourseRegistration;
import presentation.CourseRegistrationMenu;

import java.util.Scanner;

public class BusinessRegistration {
    public static void displayRegistration(){
        if(CourseRegistrationMenu.courseRegistrationList.isEmpty()){
            System.out.println("Chưa có sinh viên nào đăng ký khóa học");
        }
        for(CourseRegistration courseRegistration : CourseRegistrationMenu.courseRegistrationList){
            courseRegistration.displayRegistration();
        }
    }
    public static void addNewRegistration(Scanner scanner){
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.inputData(scanner);
        CourseRegistrationMenu.courseRegistrationList.add(courseRegistration);
        System.out.println("Đăng ký thành công!");
    }
    public static void unsubscribe(Scanner scanner){
        System.out.print("Nhập vào mã đăng ký muốn hủy: ");
        int id = Integer.parseInt(scanner.nextLine());
        int status = 0;
        for(CourseRegistration courseRegistration : CourseRegistrationMenu.courseRegistrationList){
            if(courseRegistration.getCrid() == id){
                if(courseRegistration.getStatus() == CourseRegistration.CourseStatus.PENDING){
                    courseRegistration.setStatus(CourseRegistration.CourseStatus.DROPPED);
                    status = 2;
                }
                status = 1;
            }
        }
        if(status == 0){
            System.out.println("Không tìm thấy đăng ký khóa học");
        } else if (status == 1) {
            System.out.println("Trạng thái không thể hủy");
        }else {
            System.out.println("Hủy đăng ký thành công");
        }
    }
    public static void subscribe(Scanner scanner){
        System.out.print("Nhập vào mã đăng ký muốn duyệt: ");
        int id = Integer.parseInt(scanner.nextLine());
        int status = 0;
        for(CourseRegistration courseRegistration : CourseRegistrationMenu.courseRegistrationList){
            if(courseRegistration.getCrid() == id){
                if(courseRegistration.getStatus() == CourseRegistration.CourseStatus.PENDING){
                    courseRegistration.setStatus(CourseRegistration.CourseStatus.ENROLLED);
                    status = 2;
                }
                status = 1;
            }
        }
        if(status == 0){
            System.out.println("Không tìm thấy đăng ký khóa học");
        } else if (status == 1) {
            System.out.println("Trạng thái không thể duyệt");
        }else {
            System.out.println("Duyệt đăng ký thành công");
        }
    }
}
