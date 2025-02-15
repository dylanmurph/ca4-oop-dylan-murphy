package Util;

import DAOs.ExpenseDAO;
import DTOs.Expense;

import java.sql.SQLException;

public class ExpensesUtil {
    private static final ExpenseDAO expense = new ExpenseDAO();

    public static void showExpenseTable() throws SQLException {
    }

    public static void addExpense() throws SQLException {
        String newTitle = ValidateUtil.getValidTitle();
        if (newTitle == null) {
            return;
        }

        String newNote = ValidateUtil.getValidNote();
        if (newNote == null) {
            return;
        }

        double amount = ValidateUtil.getValidAmount();
        if (amount == -1) {
            return;
        }

        String newDate = ValidateUtil.getValidDate();
        if (newDate == null) {
            return;
        }

        Expense newExpense = new Expense(newTitle, newNote, amount, newDate);
        if (expense.create(newExpense)) {
            System.out.println(ColourUtil.green("Expense added successfully."));
        } else {
            System.out.println(ColourUtil.red("Expense creation failed."));
        }
    }

    public static boolean readExpense(int id) throws SQLException {
        Expense e = expense.read(id);
        if (e != null) {
            System.out.println(e);
            return true;
        } else {
            System.out.println(ColourUtil.red("Expense not found. Please try again."));
            return false;
        }
    }

    public static boolean updateExpense(int id) throws SQLException {
        Expense e = expense.read(id);
        if (e != null) {
            System.out.println(e + "\n Enter details to update.");
        } else {
            System.out.println("Expense not found. Please try again.");
            return false;
        }

        String newTitle = ValidateUtil.getValidTitle();
        if (newTitle == null) {
            return false;
        }

        String newNote = ValidateUtil.getValidNote();
        if (newNote == null) {
            return false;
        }

        double amount = ValidateUtil.getValidAmount();
        if (amount == -1) {
            return false;
        }

        String newDate = ValidateUtil.getValidDate();
        if (newDate == null) {
            return false;
        }

        Expense updatedExpense = new Expense(newTitle, newNote, amount, newDate);
        if (expense.update(id, updatedExpense)) {
            System.out.println(ColourUtil.green("Expense updated successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Expense update failed."));
            return false;
        }
    }

    public static void deleteExpense() throws SQLException {
    }

    public static void calculateTotalExpenses() throws SQLException {
    }

    public static void generateMonthlyReport() throws SQLException {
    }


}
