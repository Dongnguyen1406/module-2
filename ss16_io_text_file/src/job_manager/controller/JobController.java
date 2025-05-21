package job_manager.controller;

import job_manager.common.IdNotFoundException;
import job_manager.entity.Expense;
import job_manager.service.ExpenseService;
import job_manager.service.IExpenseService;
import job_manager.view.ExpenseView;

import java.util.List;

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
        try {
            int expenseCodeToDelete = ExpenseView.inputExpenseCode();
            boolean isDelete = expenseService.delete(expenseCodeToDelete);
            if (isDelete){
                System.out.println("Xóa thành công!");
            } else {
                throw new IdNotFoundException("Mã chi tiêu không tồn tại !");
            }
        }catch (IdNotFoundException e){
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println("Mã chi tiêu phải là một số !");
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

    public static void sortByNameAsc() {
        List<Expense> sorted = expenseService.sortByNameAsc();
        ExpenseView.displayJob(sorted);
    }

    public static void sortByAmountDescThenNameAsc() {
        List<Expense> sorted = expenseService.sortByAmountDescThenNameAsc();
        ExpenseView.displayJob(sorted);
    }
}
