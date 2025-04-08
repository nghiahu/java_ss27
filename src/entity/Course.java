package entity;

import util.validate;
import util.validateCourse;

import java.util.Scanner;

public class Course implements IApp {
    private String courseId;
    private String courseName;
    private Boolean status;

    public Course() {
    }

    public Course(String courseId, String courseName, Boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        while (true) {
            try {
                this.courseId = validateCourse.validateId(scanner);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                this.courseName = validateCourse.validateName(scanner, 20, 100);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                this.status = validate.validateBoolean(scanner, "Nhập vào trạng thái khóa học: ");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void displayCourse() {
        System.out.println("Mã khóa học: " + courseId + " - Tên khóa học: " + courseName + " - Trạng thái: " + status);
    }
}
