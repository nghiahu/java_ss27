package entity;

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

    }
}
