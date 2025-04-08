package entity;

import presentation.CourseMenu;
import presentation.StudentMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class CourseRegistration implements IApp{
    private static int idSequence = 0;
    private int crid;
    private String studentId;
    private String courseId;
    private LocalDate registrationDate;
    public enum CourseStatus {PENDING, ENROLLED, DROPPED}
    private CourseStatus status;

    public CourseRegistration() {
        this.crid = ++idSequence;
        this.status = CourseStatus.PENDING;
    }

    public CourseRegistration(String studentId, String courseId, LocalDate registrationDate, CourseStatus status) {
        this.crid = ++idSequence;
        this.studentId = studentId;
        this.courseId = courseId;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    public int getCrid() {
        return crid;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        while(true){
            System.out.println("Nhập vào mã sinh viên đăng ký: ");
            String input = scanner.nextLine();
            boolean found = false;
            for (Student student : StudentMenu.studentList) {
                if (student.getStudentId().equals(input)) {
                    this.studentId = student.getStudentId();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy sinh viên!");
            }else {
                break;
            }
        }
        while(true){
            System.out.println("Nhập vào mã khóa học đăng ký: ");
            String input = scanner.nextLine();
            boolean found = false;
            for (Course course : CourseMenu.courseList) {
                if (course.getCourseId().equals(input)) {
                    this.courseId = course.getCourseId();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy khóa học viên!");
            }else {
                break;
            }
        }
    }
    public void displayRegistration(){
        System.out.println("Mã đăng ký: " + crid + " - Mã sinh viên: " + studentId + " - Mã khóa học: " + courseId + " - Ngày đăng ký: "+ registrationDate + "Trạng thái: " + status);
    }
}
