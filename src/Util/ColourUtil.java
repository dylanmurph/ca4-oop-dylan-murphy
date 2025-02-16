package Util;

public class ColourUtil {
    public static final String RED = "\u001B[91m";
    public static final String GREEN = "\u001B[92m";
    public static final String YELLOW = "\u001B[93m";
    public static final String WHITE = "\u001B[97m";
    public static final String RESET = "\u001B[0m";

    public static String red(String output) {
        return RED + output + RESET;
    }


    public static String green(String output) {
        return GREEN + output + RESET;
    }


    public static String yellow(String output) {
        return YELLOW + output + RESET;
    }


    public static String white(String output) {
        return WHITE + output + RESET;
    }


    public static void startWhite() {
        System.out.println(WHITE);
    }


    public static void reset() {
        System.out.println(RESET);
    }
}
