package entity;

import java.util.Scanner;

public class Student extends Person implements IApp {
    private String studentId;
    private double gpa;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void inputData(Scanner scanner) {

    }
}

