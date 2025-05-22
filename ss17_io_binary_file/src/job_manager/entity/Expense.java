package job_manager.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Expense implements Serializable {
    private int expenseCode;
    private String expenseName;
    private LocalDate expenseDate;
    private double expenseAmount;
    private String expenseDescription;

    public Expense(int expenseCode, String expenseName, LocalDate expenseDate, double expenseAmount, String expenseDescription) {
        this.expenseCode = expenseCode;
        this.expenseName = expenseName;
        this.expenseDate = expenseDate;
        this.expenseAmount = expenseAmount;
        this.expenseDescription = expenseDescription;
    }

    public int getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(int expenseCode) {
        this.expenseCode = expenseCode;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseCode=" + expenseCode +
                ", expenseName='" + expenseName + '\'' +
                ", expenseDate=" + expenseDate +
                ", expenseAmount=" + expenseAmount +
                ", expenseDescription='" + expenseDescription + '\'' +
                '}';
    }

    public String toFileBinary() {
        return expenseCode + "," +
                expenseName + "," +
                expenseDate + "," +
                expenseAmount + "," +
                expenseDescription;
    }
}
