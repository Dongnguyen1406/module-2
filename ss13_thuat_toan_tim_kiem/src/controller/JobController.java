package controller;

import entity.Expense;
import service.ExpenseService;
import service.IExpenseService;
import view.ExpenseView;

import java.util.List;
import java.util.Scanner;

public class JobController {
    private static final IExpenseService expenseService = new ExpenseService();
    
    public static void displayJob(){
        System.out.println("Danh sách chi tiêu");
        List<Expense> expenses = expenseService.getAll();
        ExpenseView.displayJob(expenses);
    }
    
    public static void addJob(){
        Expense expense = ExpenseView.inputExpenseInfo();
        expenseService.add(expense);
        System.out.println("Thêm mới thành công!");
    }
    
    public static void deleteJob(){
        int expenseCodeToDelete = ExpenseView.inputExpenseCode();
        boolean isDelete = expenseService.delete(expenseCodeToDelete);
        if (isDelete){
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tim thấy mã " + expenseCodeToDelete + " để xóa !");
        }
    }
    
    public static void updateJob(){
        int expenseCodeToUpdate = ExpenseView.inputExpenseCode();
        if (expenseService.isExist(expenseCodeToUpdate)){
            Expense expense = ExpenseView.inputExpenseInfoToUpdate(expenseCodeToUpdate);
            expenseService.update(expense);
        } else {
            System.out.println("Mã chi tiêu không tồn tại!");
        }
    }
    
    public static void searchJobByExpenseCode(){
        int expenseCode = ExpenseView.inputExpenseCode();
        List<Expense> result = expenseService.searchByExpenseCode(expenseCode);
        if (result.isEmpty()){
            System.out.println("Không tìm thấy mã chi tiêu " + expenseCode);
        } else {
            ExpenseView.displayJob(result);
        }
    }

    public static void searchJobByExpenseName(){
        String expenseName = ExpenseView.inputExpenseName();
        List<Expense> result = expenseService.searchByExpenseName(expenseName);
        if (result.isEmpty()){
            System.out.println("Không tìm thấy tên chi tiêu " + expenseName);
        } else {
            ExpenseView.displayJob(result);
        }
    }
}
