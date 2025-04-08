package presentation;

import java.util.Scanner;

public class StudentMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean Exit = false;
        do {
            System.out.println("************************* STUDENT MENU *************************");
            System.out.println("1. Danh sách sinh viên được sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    Exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 - 5");
            }
        }while (!Exit);
    }
}
