package presentation;

import java.util.Scanner;

public class UniversityManager {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************************* UNIVERSITY MENU **********************");
            System.out.println("1.Quản lý khóa học");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Quản lý sinh viên");
            System.out.println("4. Đăng ký khóa học");
            System.out.println("5. Quản lý lớp học");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CourseMenu.main(args);
                    break;
                case 2:
                    TearcherMenu.main(args);
                    break;
                case 3:
                    StudentMenu.main(args);
                    break;
                case 4:
                    CourseRegistrationMenu.main(args);
                    break;
                case 5:
                    ClassRoomMenu.main(args);
                    break;
                case 6:
                    Dashboard.main(args);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp l vui lòng chọn từ 1 - 7");
            }
        }while (true);
    }
}
