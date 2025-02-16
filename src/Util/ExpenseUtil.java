package Util;

import DAOs.ExpenseDAO;
import DTOs.Expense;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExpenseUtil {
    private static final ExpenseDAO expense = new ExpenseDAO();

    public static void printExpenseTable(ArrayList<Expense> expenseTable) {
        System.out.println(" " + "-".repeat(181));
        System.out.printf("| %-5s | %-40s | %-100s | %-10s | %-12s |%n", "ID", "Title", "Note", "Amount", "Date");
        System.out.println(" " + "-".repeat(181));

        for (Expense e : expenseTable) {
            System.out.printf("| %-5d | %-40s | %-100s | %-10.2f | %-12s |%n",
                    e.getId(),
                    e.getTitle(),
                    e.getNote(),
                    e.getAmount(),
                    e.getDate());
        }

        System.out.println(" " + "-".repeat(181));
    }

    public static void showExpenseTable() throws SQLException {
        ArrayList<Expense> expenseTable = expense.readAll();
        printExpenseTable(expenseTable);
    }

    public static boolean addExpense() throws SQLException {
        Expense newExpense = (Expense) AccountsUtil.validateDbInput("Expense");

        if (newExpense != null && expense.create(newExpense)) {
            System.out.println(ColourUtil.green("Expense added successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Expense creation failed."));
            return false;
        }
    }

    public static boolean readExpense(int id) throws SQLException {
        Expense e = expense.read(id);
        if (e != null) {
            System.out.println(e);
            return true;
        } else {
            System.out.println(ColourUtil.red("Expense not found"));
            return false;
        }
    }

    public static boolean updateExpense(int id) throws SQLException {
        Expense e = expense.read(id);
        if (e == null) {
            System.out.println(ColourUtil.red("Expense not found"));
            return false;
        }

        System.out.println(e + "\n Enter details to update.");
        Expense updatedExpense = (Expense) AccountsUtil.validateDbInput("Expense");

        if (updatedExpense != null && expense.update(id, updatedExpense)) {
            System.out.println(ColourUtil.green("Expense updated successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Expense update failed."));
            return false;
        }
    }

    public static boolean deleteExpense(int id) throws SQLException {
        if (expense.delete(id)) {
            System.out.println(ColourUtil.green("Expense deleted successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Expense delete failed"));
            return false;
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
