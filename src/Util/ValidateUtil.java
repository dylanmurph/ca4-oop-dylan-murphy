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
            if (kb.hasNextInt()) {
                num = kb.nextInt();
                kb.nextLine();
                break;
            } else if (kb.nextLine().trim().equalsIgnoreCase("exit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                num = -1;
                break;
            } else {
                System.out.println("Invalid input, enter integer value");
            }
        }
        return num;
    }

    public static String getValidTitle() {
        String title;

        while (true) {
            System.out.println("Enter title: ");
            title = kb.nextLine().trim();

            if (title.equalsIgnoreCase("-exit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return null;
            } else {
                if (title.isEmpty() || title.length() > 40) {
                    System.out.println(ColourUtil.red("Title must be 1-40 characters long."));
                } else {
                    break;
                }
            }
        }
        return title;
    }

    public static String getValidNote() {
        String note;

        while (true) {
            System.out.println("Enter note: ");
            note = kb.nextLine().trim();

            if (note.equalsIgnoreCase("-exit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return null;
            } else {
                if (note.length() > 100) {
                    System.out.println(ColourUtil.red("Note cannot contain more than 100 characters."));
                } else {
                    break;
                }
            }
        }
        return note;
    }

    public static double getValidAmount() {
        double amount;

        while (true) {
            System.out.println("Enter amount: ");
            amount = kb.nextDouble();
            kb.nextLine();

            if (String.valueOf(amount).equalsIgnoreCase("-exit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return -1;
            } else {
                if (amount <= 0) {
                    System.out.println(ColourUtil.red("Amount must be greater than 0."));
                } else {
                    break;
                }
            }
        }
        return Math.round(amount * 100.0) / 100.0;
    }

    public static String getValidDate() {
        String date;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);

        while (true) {
            System.out.println("Enter date format: YYYY-MM-DD: ");
            date = kb.nextLine().trim();

            if (date.equalsIgnoreCase("-exit")) {
                System.out.println(ColourUtil.red("Returning to menu"));
                return null;
            } else {
                if (date.isEmpty()) {
                    System.out.println(ColourUtil.red("Date cannot be empty."));
                } else {
                    try {
                        sdf.parse(date);
                        break;
                    } catch (ParseException e) {
                        System.out.println(ColourUtil.red("Date must be a valid date in format YYYY-MM-DD"));
                    }
                }
            }
        }
        return date;
    }
}
