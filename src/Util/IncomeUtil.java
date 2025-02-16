package Util;

import DAOs.IncomeDAO;
import DTOs.Income;

import java.sql.SQLException;
import java.util.ArrayList;

public class IncomeUtil {
    private static final IncomeDAO income = new IncomeDAO();

    public static void printIncomeTable(ArrayList<Income> incomeTable) {
        ColourUtil.startWhite();
        TableUtil.tableHeader();

        for (Income i : incomeTable) {
            TableUtil.tableRow(i.getId(), i.getTitle(), i.getNote(), i.getAmount(), i.getDate());
        }

        TableUtil.tableFooter();
        ColourUtil.reset();
    }

    public static void showIncomeTable() {
        try {
            ArrayList<Income> incomeTable = income.readAll();
            double incomeTotal = 0;

            for (Income i : incomeTable) {
                incomeTotal += i.getAmount();
            }

            incomeTotal = Math.round(incomeTotal * 100) / 100.0;

            printIncomeTable(incomeTable);
            System.out.printf("\n%153s | %-10.2f%n", "Total Income", incomeTotal);

        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
        }
    }

    public static void addIncome() {
        try {
            Income newIncome = (Income) AccountsUtil.validateDbInput("Income");

            if (newIncome != null && income.create(newIncome)) {
                System.out.println(ColourUtil.green("Income added successfully."));
            }
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
        }
    }

    public static boolean readIncome(int id) {
        try {
            Income i = income.read(id);
            if (i != null) {
                System.out.println(i);
                return true;
            } else {
                System.out.println(ColourUtil.red("Income not found"));
                return false;
            }
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
            return false;
        }
    }

    public static boolean updateIncome(int id) {
        try {
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
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
            return false;
        }
    }

    public static void deleteIncome(int id) {
        try {
            if (income.delete(id)) {
                System.out.println(ColourUtil.green("Income deleted successfully."));
            } else {
                System.out.println(ColourUtil.red("Income delete failed"));
            }
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
        }
    }

    public static double calculateTotalIncome() {
        try {
            ArrayList<Income> incomes = income.readAll();
            double total = 0;
            for (Income i : incomes) {
                total += i.getAmount();
            }
            return total;
        } catch (SQLException e) {
            System.out.println(ColourUtil.red("Database error\n" + e.getMessage()));
            return -1;
        }
    }
}
