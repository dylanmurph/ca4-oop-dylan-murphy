package Util;

import DTOs.Expense;
import DAOs.ExpenseDAO;
import DTOs.Income;
import DAOs.IncomeDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccountsUtil {
    public static void generateMonthlyReport(int month) {
        try {
            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            ExpenseDAO expenseDAO = new ExpenseDAO();
            IncomeDAO incomeDAO = new IncomeDAO();

            double expenseTotal = 0, incomeTotal = 0, monthlyTotal;

            ArrayList<Income> incomes = incomeDAO.readByMonth(month);
            ArrayList<Expense> expenses = expenseDAO.readByMonth(month);

            System.out.println(ColourUtil.white("\nTotal Income for Month: " + months[month - 1]));
            IncomeUtil.printIncomeTable(incomes);

            System.out.println(ColourUtil.white("\nTotal Expenses for Month: " + months[month - 1]));
            ExpenseUtil.printExpenseTable(expenses);

            for (Expense e : expenses) {
                expenseTotal += e.getAmount();
            }

            for (Income i : incomes) {
                incomeTotal += i.getAmount();
            }

            incomeTotal = Math.round(incomeTotal * 100) / 100.0;
            System.out.printf("\n%153s | %-10.2f%n", "Total Income", incomeTotal);

            expenseTotal = Math.round(expenseTotal * 100) / 100.0;
            System.out.printf("%153s | %-10.2f%n", "Total Expense", expenseTotal);

            monthlyTotal = incomeTotal - expenseTotal;
            System.out.printf("%153s | %-10.2f%n", "Balance", monthlyTotal);

        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
        }
    }


    public static Object validateDbInput(String type) {
        if (!type.equals("Expense") && !type.equals("Income")) {
            System.out.println(ColourUtil.red("Invalid object type"));
            return null;
        }

        String title = ValidateUtil.getValidTitle();
        if (title.equalsIgnoreCase("/quit")) {
            return null;
        }

        String note = ValidateUtil.getValidNote();
        if (note.equalsIgnoreCase("/quit")) {
            return null;
        }

        double amount = ValidateUtil.getValidAmount();
        if (amount == -1) return null;

        String date = ValidateUtil.getValidDate();
        if (date.equalsIgnoreCase("/quit")) {
            return null;
        }

        if (type.equals("Expense")) {
            return new Expense(title, note, amount, date);
        } else {
            return new Income(title, note, amount, date);
        }
    }

}
