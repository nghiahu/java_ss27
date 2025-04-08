package business;

import entity.ClassRoom;
import entity.CourseRegistration;
import entity.Student;
import entity.Teacher;
import presentation.ClassRoomMenu;
import presentation.CourseRegistrationMenu;
import presentation.StudentMenu;
import presentation.TearcherMenu;
import util.validate;
import util.validatePerson;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BusinessStudent {
    public static void addNewStudent(Scanner scanner) throws Exception {
        Student student = new Student();
        student.inputData(scanner);
        StudentMenu.studentList.add(student);
    }
    public static void displayStudent() {
        List<Student> studentListByName = StudentMenu.studentList.stream().sorted(Comparator.comparing(Student::getName)).toList();
        if (!studentListByName.isEmpty()) {
            for (Student student : studentListByName) {
                student.displayData();
            }
        }else {
            System.out.println("Chưa có sinh viên nào!");
        }
    }
    public static void updateTeacher(Scanner scanner) {
        System.out.print("Nhập vào mã sinh viên muốn sửa: ");
        String idStudent = scanner.nextLine();
        boolean found = false;
        for (Student student : StudentMenu.studentList) {
            if (student.getStudentId().equals(idStudent)) {
                found = true;
                boolean Exit = false;
                do {
                    System.out.println("*************************MENU UPDATE STUDENT *************************");
                    System.out.println("1. Sửa tên sinh viên");
                    System.out.println("2. Sửa tuổi");
                    System.out.println("3. Sửa địa chỉ");
                    System.out.println("4. Sửa số điện thoại");
                    System.out.println("5. Sửa email");
                    System.out.println("6. Sửa giới tính");
                    System.out.println("7. Sửa điểm GPA");
                    System.out.println("8: Thoát");
                    System.out.print("Lựa chọn: ");
                    int choice = 0;
                    try {
                        choice = Integer.parseInt(scanner.nextLine());
                    }catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                    switch (choice) {
                        case 1:
                            while (true){
                                try {
                                    student.setName(validate.validateString(scanner,0,150,"Nhập vào tên: "));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 2:
                            while (true){
                                try {
                                    student.setAge(validate.validateInt(scanner,18,"Nhập vào tuổi: "));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 3:
                            while (true){
                                try {
                                    student.setAddress(validate.validateString(scanner,0,255,"Nhập địa chỉ: "));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 4:
                            while (true){
                                try {
                                    student.setPhone(validatePerson.validatePhone(scanner));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 5:
                            while (true){
                                try {
                                    student.setEmail(validatePerson.validateEmail(scanner));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 6:
                            try {
                                student.setSex(validatePerson.validateGender(scanner));
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 7:
                            while (true){
                                try {
                                    student.setGpa(validate.validateDouble(scanner,0,"Nhập điểm trung bình của sinh viên: "));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 8:
                            Exit = true;
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại!");
                    }
                }while (!Exit);
                break;
            }
        }
        if (found) {
            System.out.println("Cập nhập thàn công");
        }else {
            System.out.println("Không tìm thấy sinh viên!");
        }
    }
    public static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập vào mã sinh viên muốn xóa: ");
        String idStudent = scanner.nextLine();
        boolean found = false;
        boolean isClass = false;
        for (Student student : StudentMenu.studentList) {
            if (student.getStudentId().equals(idStudent)) {
                found = true;
                break;
            }
        }
        for(CourseRegistration courseRegistration : CourseRegistrationMenu.courseRegistrationList) {
            if (courseRegistration.getStudentId().equals(idStudent)) {
                if (courseRegistration.getStatus() != CourseRegistration.CourseStatus.DROPPED) {
                    isClass = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên!");
        } else if (isClass) {
            System.out.println("Sinh viên đã đăng ký khóa học không thể xóa");
        }else {
            StudentMenu.studentList.removeIf(student -> student.getStudentId().equals(idStudent));
            System.out.println("Xóa thành công!");
        }
    }
}
