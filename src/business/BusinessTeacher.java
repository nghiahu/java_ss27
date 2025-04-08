package business;

import entity.ClassRoom;
import entity.Course;
import entity.Teacher;
import presentation.ClassRoomMenu;
import presentation.CourseMenu;
import presentation.TearcherMenu;
import util.validate;
import util.validatePerson;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BusinessTeacher {
    public static void addNewTeacher(Scanner scanner) throws Exception {
        Teacher teacher = new Teacher();
        teacher.inputData(scanner);
        TearcherMenu.teacherList.add(teacher);
    }
    public static void displayCourse() {
        List<Teacher> teacherListByName = TearcherMenu.teacherList.stream().sorted(Comparator.comparing(Teacher::getName)).toList();
        if (!teacherListByName.isEmpty()) {
            for (Teacher teacher : teacherListByName) {
                teacher.displayData();
            }
        }else {
            System.out.println("Chưa có giảng viên nào!");
        }
    }
    public static void updateTeacher(Scanner scanner) {
        System.out.print("Nhập vào mã giảng viên muốn sửa: ");
        int IdTeacher = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        for (Teacher teacher : TearcherMenu.teacherList) {
            if (teacher.getTeacherId() == IdTeacher) {
                found = true;
                boolean Exit = false;
                do {
                    System.out.println("*************************MENU UPDATE TEACHER *************************");
                    System.out.println("1. Sửa tên giảng viên");
                    System.out.println("2. Sửa tuổi");
                    System.out.println("3. Sửa địa chỉ");
                    System.out.println("4. Sửa số điện thoại");
                    System.out.println("5. Sửa email");
                    System.out.println("6. Sửa giới tính");
                    System.out.println("7. Sửa chuyên môn");
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
                                    teacher.setName(validate.validateString(scanner,0,150,"Nhập vào tên: "));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 2:
                            while (true){
                                try {
                                    teacher.setAge(validate.validateInt(scanner,18,"Nhập vào tuổi: "));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 3:
                            while (true){
                                try {
                                    teacher.setAddress(validate.validateString(scanner,0,255,"Nhập địa chỉ: "));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 4:
                            while (true){
                                try {
                                    teacher.setPhone(validatePerson.validatePhone(scanner));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 5:
                            while (true){
                                try {
                                    teacher.setEmail(validatePerson.validateEmail(scanner));
                                    break;
                                }catch (Exception e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        case 6:
                            try {
                                teacher.setSex(validatePerson.validateGender(scanner));
                            }catch (Exception e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 7:
                            while (true){
                                try {
                                    teacher.setSubject(validate.validateString(scanner,0,255,"Nhập vào chuyên môn giảng viên: "));
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
            System.out.println("Không tìm thấy giảng viên!");
        }
    }
    public static void deleteTeacher(Scanner scanner) {
        System.out.print("Nhập vào mã giảng viên muốn xóa: ");
        int IdTeacher = Integer.parseInt(scanner.nextLine());
        boolean found = false;
        boolean isClass = false;
        for (Teacher teacher : TearcherMenu.teacherList) {
            if (teacher.getTeacherId() == IdTeacher) {
                found = true;
                break;
            }
        }
        for(ClassRoom classRoom : ClassRoomMenu.classRoomList){
            if (classRoom.getTeacherId() == IdTeacher) {
                isClass = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy giảng viên!");
        } else if (isClass) {
            System.out.println("Giảng viên đã được phân lớp không thể xóa");
        }else {
            TearcherMenu.teacherList.removeIf(teacher -> teacher.getTeacherId() == IdTeacher);
            System.out.println("Xóa thành công!");
        }
    }
}
