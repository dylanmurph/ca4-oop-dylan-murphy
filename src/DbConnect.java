import java.sql.*;

public class DbConnect {

    private final String url;
    private final String dbName;
    private final String userName;
    private final String password;

    public DbConnect(String url, String dbName, String userName, String password) {
        this.url = url;
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
    }

    public void start() {
        System.out.println("\nAttempting connection to database: " + dbName);

        try (Connection conn = DriverManager.getConnection(this.url + this.dbName, this.userName, this.password)) {
            System.out.println("Successfully connected to Database: " + dbName);
        } catch (SQLException ex) {
            System.out.println("Failed to connect to database: " + dbName);
            ex.printStackTrace();
        }
    }
}