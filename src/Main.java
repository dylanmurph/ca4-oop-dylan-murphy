public class Main {
    public static void main(String[] args) {
        DbConnect at = new DbConnect("jdbc:mysql://localhost/", "accounts_tracker", "root", "");
        at.start();
    }
}