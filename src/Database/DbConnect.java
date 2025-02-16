package Database;

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

    public Connection start() throws SQLException {
            return DriverManager.getConnection(this.url + this.dbName, this.userName, this.password);
    }
}