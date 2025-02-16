package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ValidateUtil {
    private static final Scanner kb = new Scanner(System.in);

    public static int getValidInt(String message) {
        int num;
        while (true) {
            System.out.println(message);
            System.out.println("[Type '/quit' to return to menu]");
            String input = kb.nextLine().trim();

            if (input.equalsIgnoreCase("/quit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return -1;
            }

            try {
                num = Integer.parseInt(input);
                return num;
            } catch (NumberFormatException e) {
                System.out.println(ColourUtil.red("Invalid input, enter an integer value."));
            }
        }
    }


    public static String getValidTitle() {
        String title;

        while (true) {
            System.out.println("Enter title: ");
            System.out.println("[Type '/quit' to return to menu]");
            title = kb.nextLine().trim();

            if (title.equalsIgnoreCase("/quit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return title;
            }

            if (title.isEmpty() || title.length() > 40) {
                System.out.println(ColourUtil.red("Title must be 1-40 characters long."));
            } else {
                break;
            }
        }
        return title;
    }

    public static String getValidNote() {
        String note;

        while (true) {
            System.out.println("Enter note: ");
            System.out.println("[Type '/quit' to return to menu]");
            note = kb.nextLine().trim();

            if (note.equalsIgnoreCase("/quit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return note;
            }

            if (note.length() > 100) {
                System.out.println(ColourUtil.red("Note cannot contain more than 100 characters."));
            } else {
                break;
            }

        }
        return note;
    }

    public static double getValidAmount() {
        while (true) {
            System.out.println("Enter amount: ");
            System.out.println("[Type '/quit' to return to menu]");
            String input = kb.nextLine().trim();

            if (input.equalsIgnoreCase("/quit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return -1;
            }

            try {
                double amount = Double.parseDouble(input);
                if (amount <= 0) {
                    System.out.println(ColourUtil.red("Amount must be greater than 0."));
                } else {
                    return Math.round(amount * 100.0) / 100.0;
                }
            } catch (NumberFormatException e) {
                System.out.println(ColourUtil.red("Invalid format. Integer/Double value required."));
            }
        }
    }


    public static String getValidDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        while (true) {
            System.out.println("Enter date format: YYYY-MM-DD: ");
            System.out.println("[Type '/quit' to return to menu]");
            String date = kb.nextLine().trim();

            if (date.equalsIgnoreCase("/quit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return date;
            }

            if (date.isEmpty()) {
                System.out.println(ColourUtil.red("Date cannot be empty."));
                continue;
            }

            try {
                sdf.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println(ColourUtil.red("Date must be a valid date in format YYYY-MM-DD."));
            }
        }
    }

}
