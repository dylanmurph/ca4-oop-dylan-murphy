package Util;

import DAOs.IncomeDAO;
import DTOs.Income;

import java.sql.SQLException;

public class IncomeUtil {
    private static final IncomeDAO income = new IncomeDAO();

    public static void showIncomeTable() throws SQLException {
    }

    public static void addIncome() throws SQLException {
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

        Income newIncome = new Income(newTitle, newNote, amount, newDate);
        if (income.create(newIncome)) {
            System.out.println(ColourUtil.green("Income added successfully."));
        } else {
            System.out.println(ColourUtil.red("Income creation failed."));
        }
    }

    public static boolean readIncome(int id) throws SQLException {
        Income i = income.read(id);
        if (i != null) {
            System.out.println(i);
            return true;
        } else {
            System.out.println(ColourUtil.red("Income not found. Please try again."));
            return false;
        }
    }

    public static boolean updateIncome(int id) throws SQLException {
        Income i = income.read(id);
        if (i != null) {
            System.out.println(i + "\n Enter details to update.");
        } else {
            System.out.println(ColourUtil.red("Income not found. Please try again."));
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

        Income updatedIncome = new Income(newTitle, newNote, amount, newDate);
        if (income.update(id, updatedIncome)) {
            System.out.println(ColourUtil.green("Income updated successfully."));
            return true;
        } else {
            System.out.println(ColourUtil.red("Income update failed."));
            return false;
        }
    }

    public static void deleteIncome() throws SQLException {
    }

    public static void calculateTotalIncome() throws SQLException {
    }

}
