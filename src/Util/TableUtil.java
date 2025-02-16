package Util;

public class TableUtil {
    public static void tableHeader() {
        System.out.println(" " + "-".repeat(181));
        System.out.printf("| %-5s | %-40s | %-100s | %-10s | %-12s |%n", "ID", "Title", "Note", "Amount", "Date");
        System.out.println(" " + "-".repeat(181));
    }

    public static void tableRow(int id, String title, String note, double amount, String date) {
        System.out.printf("| %-5d | %-40s | %-100s | %-10.2f | %-12s |%n", id, title, note, amount, date);
    }

    public static void tableFooter() {
        System.out.println(" " + "-".repeat(181));
    }
}
