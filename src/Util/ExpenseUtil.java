package Util;

import DAOs.ExpenseDAO;
import DTOs.Expense;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExpenseUtil {
    private static final ExpenseDAO expense = new ExpenseDAO();

    public static void printExpenseTable(ArrayList<Expense> expenseTable) {
        ColourUtil.startWhite();
        TableUtil.tableHeader();

        for (Expense e : expenseTable) {
            TableUtil.tableRow(e.getId(), e.getTitle(), e.getNote(), e.getAmount(), e.getDate());
        }

        TableUtil.tableFooter();
        ColourUtil.reset();
    }

    public static void showExpenseTable() {
        try {
            ArrayList<Expense> expenseTable = expense.readAll();
            double expenseTotal = 0;

            for (Expense e : expenseTable) {
                expenseTotal += e.getAmount();
            }

            expenseTotal = Math.round(expenseTotal * 100) / 100.0;

            printExpenseTable(expenseTable);

            System.out.printf("%153s | %-10.2f%n", "Total Expense", expenseTotal);

        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
        }
    }

    public static void addExpense() {
        try {
            Expense newExpense = (Expense) AccountsUtil.validateDbInput("Expense");

            if (newExpense != null && expense.create(newExpense)) {
                System.out.println(ColourUtil.green("Expense added successfully."));
            }
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
        }
    }

    public static boolean readExpense(int id) {
        try {
            Expense e = expense.read(id);
            if (e != null) {
                System.out.println(e);
                return true;
            } else {
                System.out.println(ColourUtil.red("Expense not found"));
                return false;
            }
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
            return false;
        }
    }

    public static boolean updateExpense(int id) {
        try {
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
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
            return false;
        }
    }

    public static void deleteExpense(int id) {
        try {
            if (expense.delete(id)) {
                System.out.println(ColourUtil.green("Expense deleted successfully."));
            } else {
                System.out.println(ColourUtil.red("Expense delete failed"));
            }
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
        }
    }

    public static double calculateTotalExpenses() {
        try {
            ArrayList<Expense> expenses = expense.readAll();
            double total = 0;
            for (Expense e : expenses) {
                total += e.getAmount();
            }
            return total;
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
            return -1;
        }
    }
}
