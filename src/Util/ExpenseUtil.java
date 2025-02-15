package Util;

import DAOs.ExpenseDAO;
import DTOs.Expense;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExpenseUtil {
    private static final ExpenseDAO expense = new ExpenseDAO();

    public static void showExpensesTable() throws SQLException {
        ArrayList<Expense> expensesTable = expense.readAll();
        System.out.println(" " + "-".repeat(181));
        System.out.printf("| %-5s | %-40s | %-100s | %-10s | %-12s |%n", "ID", "Title", "Note", "Date", "Amount");
        System.out.println(" " + "-".repeat(181));
        for (Expense e : expensesTable) {
            System.out.printf("| %-5d | %-40s | %-100s | %-10.2f | %-12s |%n",
                    e.getId(),
                    e.getTitle(),
                    e.getNote(),
                    e.getAmount(),
                    e.getDateIncurred());
        }
        System.out.println(" " + "-".repeat(181));
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
            System.out.println(ColourUtil.red("Expense not found."));
            return false;
        }
    }

    public static boolean updateExpense(int id) throws SQLException {
        Expense e = expense.read(id);
        if (e != null) {
            System.out.println(e + "\n Enter details to update.");
        } else {
            System.out.println("Expense not found.");
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

    public static void deleteExpense(int id) throws SQLException {
        if (expense.delete(id)) {
            System.out.println(ColourUtil.green("Expense deleted successfully."));
        } else {
            System.out.println(ColourUtil.red("Expense delete failed"));
        }
    }

    public static double calculateTotalExpenses() throws SQLException {
        ArrayList<Expense> expenses = expense.readAll();
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }
}
