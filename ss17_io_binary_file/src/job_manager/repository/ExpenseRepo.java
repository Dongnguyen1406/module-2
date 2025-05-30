package job_manager.repository;

import job_manager.entity.Expense;
import job_manager.utils.ReadAndWriteFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExpenseRepo implements IExpenseRepo {
    private static final String FILE_EXPENSE = "src/job_manager/data/expense.dat";
    
    @Override
    public List<Expense> getAll() {
        return ReadAndWriteFile.readFileToBinary(FILE_EXPENSE);
    }

    @Override
    public void add(Expense expense) {
        List<Expense> expenseList = ReadAndWriteFile.readFileToBinary(FILE_EXPENSE);
        expenseList.add(expense);
        ReadAndWriteFile.writeFileToBinary(FILE_EXPENSE, expenseList);
    }


    @Override
    public boolean isExist(int expenseCode) {
        List<Expense> expenses = getAll();
        for (Expense expense : expenses) {
            if (expense.getExpenseCode() == expenseCode) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int expenseCode) {
        List<Expense> expenses = getAll();
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getExpenseCode() == expenseCode) {
                expenses.remove(i);
                ReadAndWriteFile.writeFileToBinary(FILE_EXPENSE, expenses);
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Expense expense) {
        List<Expense> expenses = getAll();
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getExpenseCode() == expense.getExpenseCode()) {
                expenses.set(i, expense);
            }
        }
        ReadAndWriteFile.writeFileToBinary(FILE_EXPENSE, expenses);
    }

    @Override
    public List<Expense> searchByExpenseCode(int expenseCode) {
        List<Expense> expenseList = getAll();
        List<Expense> result = new ArrayList<>();
        for (Expense expense : expenseList) {
            if (expense.getExpenseCode() == expenseCode) {
                result.add(expense);
            }
        }
        return result;
    }

    @Override
    public List<Expense> searchByExpenseName(String expenseName) {
        List<Expense> expenseList = getAll();
        List<Expense> result = new ArrayList<>();
        for (Expense expense : expenseList) {
            if (expense.getExpenseName().toLowerCase().contains(expenseName.toLowerCase())) {
                result.add(expense);
            }
        }
        return result;
    }

    @Override
    public List<Expense> sortByNameAsc() {
        List<Expense> expenseList = getAll();
        List<Expense> sortedList = new ArrayList<>(expenseList);
        sortedList.sort(Comparator.comparing(Expense::getExpenseName, String.CASE_INSENSITIVE_ORDER));
        return sortedList;
    }

    @Override
    public List<Expense> sortByAmountDescThenNameAsc() {
        List<Expense> expenseList = getAll();
        List<Expense> sortedList = new ArrayList<>(expenseList);
        sortedList.sort(Comparator.comparing(Expense::getExpenseAmount, Comparator.reverseOrder()).thenComparing(Expense::getExpenseName, String.CASE_INSENSITIVE_ORDER));
        return sortedList;
    }
}
