package job_manager.service;

import job_manager.entity.Expense;
import job_manager.repository.ExpenseRepo;
import job_manager.repository.IExpenseRepo;

import java.util.List;

public class ExpenseService implements IExpenseService{
    public static IExpenseRepo expenseRepo = new ExpenseRepo();
    
    @Override
    public List<Expense> getAll() {
        return expenseRepo.getAll();
    }

    @Override
    public void add(Expense expense) {
        expenseRepo.add(expense);
    }

    @Override
    public boolean isExist(int expenseCode) {
        return expenseRepo.isExist(expenseCode);
    }

    @Override
    public boolean delete(int expenseCode) {
        return expenseRepo.delete(expenseCode);
    }

    @Override
    public void update(Expense expense) {
        expenseRepo.update(expense);
    }

    @Override
    public List<Expense> searchByExpenseCode(int expenseCode) {
        return expenseRepo.searchByExpenseCode(expenseCode);
    }

    @Override
    public List<Expense> searchByExpenseName(String expenseName) {
        return expenseRepo.searchByExpenseName(expenseName);
    }

    @Override
    public List<Expense> sortByNameAsc() {
        return expenseRepo.sortByNameAsc();
    }

    @Override
    public List<Expense> sortByAmountDescThenNameAsc() {
        return expenseRepo.sortByAmountDescThenNameAsc();
    }
}
