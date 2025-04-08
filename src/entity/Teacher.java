package entity;

import java.util.Scanner;

public class Teacher extends Person implements IApp{
    private static int idSequence = 0;
    private int teacherId;
    private String subject;

    public Teacher() {
        this.teacherId = ++idSequence;
    }

    public Teacher(String name, int age, String address, String phone, String email, Gender sex, String subject) {
        super(name, age, address, phone, email, sex);
        this.teacherId = ++idSequence;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void inputData(Scanner scanner) {
        while (true){
            try {

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
