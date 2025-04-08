package entity;

import util.validate;
import util.validatePerson;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    public enum Gender {MALE, FEMALE, OTHER};
    private Gender sex;

    public Person() {
    }

    public Person(String name, int age, String address, String phone, String email, Gender sex) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getSex() {
        return sex;
    }

    public void setSex(Gender sex) {
        this.sex = sex;
    }
    public void inputData(Scanner scanner) throws Exception {
        while (true){
            try {
                this.name = validate.validateString(scanner,0,150,"Nhập vào tên: ");
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try {
                this.age = validate.validateInt(scanner,18,"Nhập vào tuổi: ");
                scanner.nextLine();
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try {
                this.address = validate.validateString(scanner,0,255,"Nhập địa chỉ: ");
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try {
                this.phone = validatePerson.validatePhone(scanner);
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        while (true){
            try {
                this.email = validatePerson.validateEmail(scanner);
                break;
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        try {
            this.sex = validatePerson.validateGender(scanner);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void displayData(){
        System.out.println("Tên: " + this.name + " - Tuổi " + this.age + " - Địa chỉ: " + this.address + " - Số điện thoại " + this.phone);
        System.out.println("Email: " + this.email);
        System.out.println("Giới tính: "  + this.sex);
    }
}
