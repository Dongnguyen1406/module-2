package repository;

import entity.Expense;

import java.util.List;

public interface IExpenseRepo {
    List<Expense> getAll();
    void add(Expense expense);
    boolean isExist(int expenseCode);
    boolean delete(int expenseCode);
    void update(Expense expense);
    List<Expense> searchByExpenseCode(int expenseCode);
    List<Expense> searchByExpenseName(String expenseName);
}
