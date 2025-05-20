package view;

import entity.Expense;
import service.ExpenseService;
import service.IExpenseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ExpenseView {
    public static Scanner scanner = new Scanner(System.in);
    public static IExpenseService expenseService = new ExpenseService();
    
    public static void displayJob(List<Expense> expenses){
        for (Expense expense : expenses){
            System.out.println(expense);
        }
    }
    
    public static Expense inputExpenseInfo(){
        int expenseCode;
        while (true){
            System.out.println("Nhập mã chi tiêu: ");
            expenseCode = Integer.parseInt(scanner.nextLine());
            if (expenseService.isExist(expenseCode)){
                System.out.println("Mã chi tiêu đã tồn tại !");
            } else {
                break;
            }
        }
        
        String expenseName;
        System.out.println("Nhập tên chi tiêu: ");
        expenseName = scanner.nextLine();

        LocalDate expenseDate;
        System.out.println("Nhập ngày chi: ");
        expenseDate = LocalDate.parse(scanner.nextLine());
        
        Double expenseAmount;
        System.out.println("Nhập số tiền chi: ");
        expenseAmount = Double.parseDouble(scanner.nextLine());
        
        String expenseDescription;
        System.out.println("Nhập mô tả thêm: ");
        expenseDescription = scanner.nextLine();
        
        return new Expense(expenseCode, expenseName, expenseDate, expenseAmount, expenseDescription);
    }
    
    public static int inputExpenseCode(){
        System.out.println("Nhập mã chi tiêu: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputExpenseName(){
        System.out.println("Nhập tên chi tiêu: ");
        return scanner.nextLine();
    }

    public static Expense inputExpenseInfoToUpdate(int expenseCode){
        String expenseName;
        System.out.println("Nhập tên chi tiêu: ");
        expenseName = scanner.nextLine();

        LocalDate expenseDate;
        System.out.println("Nhập ngày chi: ");
        expenseDate = LocalDate.parse(scanner.nextLine());

        Double expenseAmount;
        System.out.println("Nhập số tiền chi: ");
        expenseAmount = Double.parseDouble(scanner.nextLine());

        String expenseDescription;
        System.out.println("Nhập mô tả thêm: ");
        expenseDescription = scanner.nextLine();

        return new Expense(expenseCode, expenseName, expenseDate, expenseAmount, expenseDescription);
    }
}
