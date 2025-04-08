package presentation;

import entity.ClassRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassRoomMenu {
    public static List<ClassRoom> classRoomList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean Exit = false;
        do {
            System.out.println("************************* CLASS ROOM MENU *************************");
            System.out.println("1. Danh sách lớp học sắp xếp theo ngày tạo giảm dần");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật thông tin lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Phân công giảng viên cho lớp");
            System.out.println("6. Thêm sinh viên vào cho lớp");
            System.out.println("7. Tạo lịch cho lớp học");
            System.out.println("8 Cập nhật trạng thái lớp");
            System.out.println("9. Thoát");
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
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    Exit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn từ 1 - 9");
            }
        }while (!Exit);
    }
}
