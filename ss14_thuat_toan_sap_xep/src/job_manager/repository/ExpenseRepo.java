package job_manager.repository;

import job_manager.entity.Expense;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpenseRepo implements IExpenseRepo{
    private static final List<Expense> expenseList = new ArrayList<>();
    
    static {
        expenseList.add(new Expense(1, "a", LocalDate.of(2025, 5, 20), 400000.0, "mua đồ ăn"));
        expenseList.add(new Expense(2, "b", LocalDate.of(2025, 5, 22), 400000.0, "okeoke"));
        expenseList.add(new Expense(3, "c", LocalDate.of(2025, 5, 24), 500000.0, "quần áo"));
    }
    
    @Override
    public List<Expense> getAll() {
        return expenseList;
    }

    @Override
    public void add(Expense expense) {
        expenseList.add(expense);
    }

    @Override
    public boolean isExist(int expenseCode) {
        for (Expense expense : expenseList){
            if (expense.getExpenseCode() == expenseCode){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int expenseCode) {
        for (int i = 0; i < expenseList.size(); i++) {
            if (expenseList.get(i).getExpenseCode() == expenseCode){
                expenseList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Expense expense) {
        List<Expense> expenses = getAll();
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getExpenseCode() == expense.getExpenseCode()){
                expenses.set(i, expense);
            }
        }
        List<Expense> result = new ArrayList<>();
        for (Expense expense1 : expenses){
            result.add(expense1);
        }
    }

    @Override
    public List<Expense> searchByExpenseCode(int expenseCode) {
        List<Expense> result = new ArrayList<>();
        for (Expense expense : expenseList){
            if (expense.getExpenseCode() == expenseCode){
                result.add(expense);
            }
        }
        return result;
    }

    @Override
    public List<Expense> searchByExpenseName(String expenseName) {
        List<Expense> result = new ArrayList<>();
        for (Expense expense : expenseList){
            if (expense.getExpenseName().toLowerCase().contains(expenseName.toLowerCase().trim())){
                result.add(expense);
            }
        }
        return result;
    }

    @Override
    public List<Expense> sortByNameAsc() {
        List<Expense> sortedList = new ArrayList<>(expenseList);
        sortedList.sort(Comparator.comparing(Expense::getExpenseName,String.CASE_INSENSITIVE_ORDER));
        return sortedList;
    }

    @Override
    public List<Expense> sortByAmountDescThenNameAsc() {
        List<Expense> sortedList = new ArrayList<>(expenseList);
        sortedList.sort(Comparator.comparing(Expense::getExpenseAmount, Comparator.reverseOrder()).thenComparing(Expense::getExpenseName, String.CASE_INSENSITIVE_ORDER));
        return sortedList;
    }
}
