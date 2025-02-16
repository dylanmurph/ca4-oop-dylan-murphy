// OOP CA4_DATABASE_DAO - D00223094 - Dylan Murphy

import Util.*;
import java.util.Scanner;

public class Main {
    private static final Scanner kb = new Scanner(System.in);

    public static void main(String[] args){
        mainMenu();
    }

    public static void mainMenu(){
        String input;
        do {
            ColourUtil.startWhite();
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
            ColourUtil.reset();

            input = kb.nextLine().trim();

            switch (input) {
                case "1":
                    incomeMenu();
                    break;
                case "2":
                    expensesMenu();
                    break;
                case "3":
                    while (true) {
                        int month = ValidateUtil.getValidInt("Enter a month 1-12");
                        if (month != 0) {
                            if (month >= 1 && month <= 12) {
                                AccountsUtil.generateMonthlyReport(month);
                                break;
                            } else {
                                System.out.println(ColourUtil.red("Invalid input"));
                            }
                        }
                    }
                    break;
                case "4":
                    System.out.println(ColourUtil.red("Exiting the application."));
                    break;
                default:
                    System.out.println(ColourUtil.red("Error, Please type a valid option."));
            }
        } while (!input.equals("4"));
    }

    private static void incomeMenu(){
        String input;
        int id;
        double total;
        do {
            ColourUtil.startWhite();
            System.out.print("""
                    \n  ---------------------------
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
            ColourUtil.reset();

            input = kb.nextLine().trim();

            switch (input) {
                case "1":
                    IncomeUtil.showIncomeTable();
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
                    id = ValidateUtil.getValidInt("Enter Income id to delete");
                    if (id != 0) {
                        IncomeUtil.readIncome(id);
                        while (true) {
                            System.out.println(ColourUtil.yellow("Are you sure you want to delete? (y/n)"));
                            input = kb.nextLine().trim();

                            if (input.equalsIgnoreCase("y")) {
                                IncomeUtil.deleteIncome(id);
                                break;
                            } else if (input.equalsIgnoreCase("n")) {
                                System.out.println(ColourUtil.red("Returning to menu."));
                                break;
                            } else {
                                System.out.println(ColourUtil.red("Invalid input. Please enter 'y' or 'n'."));
                            }
                        }
                    }
                    break;
                case "6":
                    total = IncomeUtil.calculateTotalIncome();
                    if(total != -1){
                        System.out.println(ColourUtil.green("Total income = " + total));
                    }
                    break;
                case "7":
                    System.out.println(ColourUtil.green("Returning to Main Menu."));
                    break;
                default:
                    System.out.println(ColourUtil.red("Error, Please type a valid option."));
            }
        } while (!input.equals("7"));
    }

    private static void expensesMenu(){
        String input;
        int id;
        double total;
        do {
            ColourUtil.startWhite();
            System.out.print("""
                    \n  ----------------------------
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
            ColourUtil.reset();

            input = kb.nextLine().trim();

            switch (input) {
                case "1":
                    ExpenseUtil.showExpenseTable();
                    break;
                case "2":
                    ExpenseUtil.addExpense();
                    break;
                case "3":
                    id = ValidateUtil.getValidInt("Enter Expense id to read");
                    if (id != 0 && ExpenseUtil.readExpense(id)) {
                        break;
                    }
                    break;
                case "4":
                    id = ValidateUtil.getValidInt("Enter Expense id to update");
                    if (id != 0) {
                        if (ExpenseUtil.updateExpense(id)) {
                            break;
                        }
                    }
                    break;
                case "5":
                    id = ValidateUtil.getValidInt("Enter Expense id to delete");
                    if (id != 0) {
                        ExpenseUtil.readExpense(id);
                        while (true) {
                            System.out.println(ColourUtil.yellow("Are you sure you want to delete? (y/n)"));
                            input = kb.nextLine().trim();

                            if (input.equalsIgnoreCase("y")) {
                                ExpenseUtil.deleteExpense(id);
                                break;
                            } else if (input.equalsIgnoreCase("n")) {
                                System.out.println(ColourUtil.red("Returning to menu."));
                                break;
                            } else {
                                System.out.println(ColourUtil.red("Invalid input. Please enter 'y' or 'n'."));
                            }
                        }
                    }
                    break;
                case "6":
                    total = ExpenseUtil.calculateTotalExpenses();
                    if(total != -1){
                        System.out.println(ColourUtil.red("Total expenses = " + total));
                    }
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
