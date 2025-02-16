package Util;

import DTOs.Expense;
import DAOs.ExpenseDAO;
import DTOs.Income;
import DAOs.IncomeDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccountsUtil {
    public static void generateMonthlyReport(int month) throws SQLException {
        ExpenseDAO expense = new ExpenseDAO();
        IncomeDAO income = new IncomeDAO();

        double expenseTotal = 0, incomeTotal = 0, monthlyTotal = 0;

        ArrayList<Income> incomes = income.readByMonth(month);
        ArrayList<Expense> expenses = expense.readByMonth(month);

        System.out.println(" " + "-".repeat(181));
        System.out.printf("| %-5s | %-40s | %-100s | %-10s | %-12s |%n", "ID", "Title", "Note", "Date", "Amount");
        System.out.println(" " + "-".repeat(181));

        for (Income i : incomes) {
            System.out.printf("| %-5d | %-40s | %-100s | %-10.2f | %-12s |%n",
                    i.getId(),
                    i.getTitle(),
                    i.getNote(),
                    i.getAmount(),
                    i.getDateEarned());
            incomeTotal += i.getAmount();
        }

        incomeTotal = Math.round(incomeTotal * 100) / 100.0;

        System.out.printf("| %-5s | %-40s | %100s | %-10.2f | %-12s |%n", "", "", "Total", incomeTotal, "");
        System.out.println(" " + "-".repeat(181));


        System.out.println(" " + "-".repeat(181));
        System.out.printf("| %-5s | %-40s | %-100s | %-10s | %-12s |%n", "ID", "Title", "Note", "Date", "Amount");
        System.out.println(" " + "-".repeat(181));

        for (Expense e : expenses) {
            System.out.printf("| %-5d | %-40s | %-100s | %-10.2f | %-12s |%n",
                    e.getId(),
                    e.getTitle(),
                    e.getNote(),
                    e.getAmount(),
                    e.getDateIncurred());
            expenseTotal += e.getAmount();
        }

        expenseTotal = Math.round(expenseTotal * 100) / 100.0;

        System.out.printf("| %-5s | %-40s | %100s | %-10.2f | %-12s |%n", "", "", "Total", expenseTotal, "");
        System.out.println(" " + "-".repeat(181));

        monthlyTotal = incomeTotal - expenseTotal;
        System.out.printf("%153s | %-10.2f%n", "Total Income", incomeTotal);
        System.out.printf("%153s | %-10.2f%n", "Total Expense", expenseTotal);
        System.out.printf("%153s | %-10.2f%n", "Balance", monthlyTotal);

    }
}
