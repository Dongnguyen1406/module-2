package job_manager.view;

import job_manager.common.ExpenseValidate;
import job_manager.entity.Expense;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ExpenseView {
    public static Scanner scanner = new Scanner(System.in);

    public static void displayJob(List<Expense> expenses) {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public static Expense inputExpenseInfo(int expenseCode) {
        String expenseName;
        while (true) {
            try {
                System.out.println("Nhập tên chi tiêu: ");
                expenseName = scanner.nextLine();
                ExpenseValidate.validateExpenseName(expenseName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        LocalDate expenseDate;
        while (true) {
            try {
                System.out.println("Nhập ngày chi: ");
                expenseDate = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Vui lòng nhập ngày đúng định dạng yyyy-MM-dd");
            }
        }

        Double expenseAmount;
        while (true) {
            try {
                System.out.println("Nhập số tiền chi: ");
                expenseAmount = Double.parseDouble(scanner.nextLine());
                if (expenseAmount < 0) {
                    System.out.println("Không được nhỏ hơn 0!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số tiền hợp lệ!");
            }
        }


        String expenseDescription;
        while (true) {
            System.out.println("Nhập mô tả thêm: ");
            expenseDescription = scanner.nextLine();
            if (expenseDescription.trim().isEmpty()) {
                System.out.println("Không đc để trống!");
            } else {
                break;
            }
        }

        return new Expense(expenseCode, expenseName, expenseDate, expenseAmount, expenseDescription);
    }

    public static int inputExpenseCode() {
        int expenseCode;
        System.out.println("Nhập mã chi tiêu: ");
        expenseCode = Integer.parseInt(scanner.nextLine());
        return expenseCode;
    }

    public static String inputExpenseName() {
        String expenseName;
        while (true) {
            try {
                System.out.println("Nhập tên chi tiêu: ");
                expenseName = scanner.nextLine();
                ExpenseValidate.validateExpenseName(expenseName);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return expenseName;
    }
    
    public static int inputExpenseCodeToCheck(){
        int expenseCode;
        while (true){
            try {
                expenseCode = inputExpenseCode();
                return expenseCode;
            }catch (NumberFormatException e){
                System.out.println("Mã chi tiêu phải là số !");
            }
        }
    }
}
