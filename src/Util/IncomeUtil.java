package Util;

import DAOs.IncomeDAO;
import DTOs.Income;

import java.sql.SQLException;
import java.util.ArrayList;

public class IncomeUtil {
    private static final IncomeDAO income = new IncomeDAO();

    public static void printIncomeTable(ArrayList<Income> incomeTable) {
        System.out.println(" " + "-".repeat(181));
        System.out.printf("| %-5s | %-40s | %-100s | %-10s | %-12s |%n", "ID", "Title", "Note", "Amount", "Date");
        System.out.println(" " + "-".repeat(181));

        for (Income i : incomeTable) {
            System.out.printf("| %-5d | %-40s | %-100s | %-10.2f | %-12s |%n",
                    i.getId(),
                    i.getTitle(),
                    i.getNote(),
                    i.getAmount(),
                    i.getDate());
        }

        System.out.println(" " + "-".repeat(181));
    }

    public static void showIncomeTable() throws SQLException {
        ArrayList<Income> incomeTable = income.readAll();
        printIncomeTable(incomeTable);
    }

    public static boolean addIncome() throws SQLException {
        Income newIncome = (Income) AccountsUtil.validateDbInput("Income");

        if (newIncome != null && income.create(newIncome)) {
            System.out.println(ColourUtil.green("Income added successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Income creation failed."));
            return false;
        }
    }

    public static boolean readIncome(int id) throws SQLException {
        Income i = income.read(id);
        if (i != null) {
            System.out.println(i);
            return true;
        } else {
            System.out.println(ColourUtil.red("Income not found"));
            return false;
        }
    }

    public static boolean updateIncome(int id) throws SQLException {
        Income i = income.read(id);
        if (i == null) {
            System.out.println(ColourUtil.red("Income not found"));
            return false;
        }

        System.out.println(i + "\n Enter details to update.");
        Income updatedIncome = (Income) AccountsUtil.validateDbInput("Income");

        if (updatedIncome != null && income.update(id, updatedIncome)) {
            System.out.println(ColourUtil.green("Income updated successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Income update failed."));
            return false;
        }
    }

    public static boolean deleteIncome(int id) throws SQLException {
        if (income.delete(id)) {
            System.out.println(ColourUtil.green("Income deleted successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Income delete failed"));
            return false;
        }
    }

    public static double calculateTotalIncome() throws SQLException {
        ArrayList<Income> incomes = income.readAll();
        double total = 0;
        for (Income i : incomes) {
            total += i.getAmount();
        }
        return total;
    }
}
