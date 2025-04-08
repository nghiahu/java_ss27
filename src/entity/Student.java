package entity;

import util.validate;
import util.validateStudent;

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
    public void inputData(Scanner scanner) throws Exception {
        super.inputData(scanner);
        while (true){
            try {
                this.studentId = validateStudent.validateIdStudent(scanner);
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try {
                this.gpa = validate.validateDouble(scanner,0,"Nhập điểm trung bình của sinh viên: ");
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
    public void displayData(){
        super.displayData();
        System.out.println("Mã sinh viên: " + this.studentId + " - GPA: " + this.gpa);
        System.out.println("--------------------------------------------------------------------");
    }
}

