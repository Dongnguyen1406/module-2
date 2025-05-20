package controller;

import java.util.Scanner;

public class MenuController {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void displayMenu() {
        boolean flag = true;
        do {
            System.out.println("-----Quản lý công việc-----" +
                    "\n 1. Hiển thị danh sách" +
                    "\n 2. Thêm" +
                    "\n 3. Xóa" +
                    "\n 4. Sửa" +
                    "\n 5. Tìm kiếm theo mã chi tiêu" +
                    "\n 6. Tìm kiếm gần đúng tên chi tiêu" +
                    "\n 7. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    JobController.displayJob();
                    break;
                case 2:
                    JobController.addJob();
                    break;
                case 3:
                    JobController.deleteJob();
                    break;
                case 4:
                    JobController.updateJob();
                    break;
                case 5:
                    JobController.searchJobByExpenseCode();
                    break;
                case 6:
                    JobController.searchJobByExpenseName();
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-6 !");
            }
        } while (flag);
    }
}
