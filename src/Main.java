// OOP CA4_DATABASE_DAO - D00223094 - D00223094 - Dylan Murphy

import Util.IncomeUtil;
import Util.ExpensesUtil;
import Util.ColourUtil;
import Util.ValidateUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner kb = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        mainMenu();
    }

    public static void mainMenu() throws SQLException {
        String input;
        do {
            System.out.print("""
                    \n  -------------------------
                     | --- Account Tracker --- |
                     | 1. Income Management    |
                     | 2. Expense Management   |
                     | 3. Monthly Report       |
                     | 4. Exit                 |
                     | -- Choose 1, 2, 3 or 4  |
                      -------------------------
                      Enter Option:\s""");

            input = kb.nextLine().trim();

            switch (input) {
                case "1":
                    incomeMenu();
                    break;
                case "2":
                    expensesMenu();
                    break;
                case "3":
                    //ExpensesUtil.generateMonthlyReport();
                    break;
                case "4":
                    System.out.println(ColourUtil.red("Exiting the application."));
                    break;
                default:
                    System.out.println(ColourUtil.red("Error, Please type a valid option."));
            }
        } while (!input.equals("4"));
    }

    private static void incomeMenu() throws SQLException {
        String input;
        int id;
        do {
            System.out.print("""
                    \n  --------------------------
                     | --- Income Management --- |
                     | 1. Show Income Table      |
                     | 2. Add Income             |
                     | 3. Read Income            |
                     | 4. Update Income          |
                     | 5. Delete Income          |
                     | 6. Calculate Total Income |
                     | 7. Back                   |
                     | -- Choose 1 - 7           |
                      --------------------------
                      Enter Option:\s""");

            input = kb.nextLine().trim();

            switch (input) {
                case "1":
                    //IncomeUtil.showIncomeTable();
                    break;
                case "2":
                    IncomeUtil.addIncome();
                    break;
                case "3":
                    id = ValidateUtil.getValidInt("Enter Income id to read");
                    if (id != 0 && IncomeUtil.readIncome(id)) {
                        break;
                    }
                    break;
                case "4":
                    id = ValidateUtil.getValidInt("Enter Income id to update");
                    if (id != 0 && IncomeUtil.updateIncome(id)) {
                        break;
                    }
                    break;
                case "5":
                    //IncomeUtil.deleteIncome();
                    break;
                case "6":
                    //IncomeUtil.calculateTotalIncome();
                    break;
                case "7":
                    System.out.println(ColourUtil.green("Returning to Main Menu."));
                    break;
                default:
                    System.out.println(ColourUtil.red("Error, Please type a valid option."));
            }
        } while (!input.equals("7"));
    }

    private static void expensesMenu() throws SQLException {
        String input;
        int id;
        do {
            System.out.print("""
                    \n  --------------------------
                     | --- Expense Management --- |
                     | 1. Show Expense Table      |
                     | 2. Add Expense             |
                     | 3. Read Expense            |
                     | 4. Update Expense          |
                     | 5. Delete Expense          |
                     | 6. Calculate Total Expense |
                     | 7. Back                    |
                     | -- Choose 1 - 7            |
                      ----------------------------
                      Enter Option:\s""");

            input = kb.nextLine().trim();

            switch (input) {
                case "1":
                    //ExpensesUtil.showExpenseTable();
                    break;
                case "2":
                    ExpensesUtil.addExpense();
                    break;
                case "3":
                    id = ValidateUtil.getValidInt("Enter Expense id to read");
                    if (id != 0 && ExpensesUtil.readExpense(id)) {
                        break;
                    }
                    break;
                case "4":
                    id = ValidateUtil.getValidInt("Enter Expense id to update");
                    if (id != 0) {
                        if (ExpensesUtil.updateExpense(id)) {
                            break;
                        }
                    }
                    break;
                case "5":
                    //ExpensesUtil.deleteExpense();
                    break;
                case "6":
                    //ExpensesUtil.calculateTotalExpenses();
                    break;
                case "7":
                    System.out.println(ColourUtil.green("Returning to Main Menu."));
                    break;
                default:
                    System.out.println(ColourUtil.red("Error, Please type a valid option."));
            }
        } while (!input.equals("7"));
    }
}
