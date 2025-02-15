package DAOs;

import DTOs.Expense;
import Database.DbConnect;

import java.sql.*;
import java.util.ArrayList;

public class ExpenseDAO implements ExpenseDAOInterface {
    private final DbConnect db = new DbConnect("jdbc:mysql://localhost/", "accounts_tracker", "root", "");

    private static final String CREATE = "INSERT INTO expenses (title, note, amount, dateIncurred) VALUES (?, ?, ?, ?)";
    private static final String READ = "SELECT * FROM expenses WHERE expenseID = ?";
    private static final String READ_ALL = "SELECT * FROM expenses";
    private static final String UPDATE = "UPDATE expenses SET title = ?, note = ?, amount = ?, dateIncurred = ? WHERE expenseID = ?";
    private static final String DELETE = "DELETE FROM expenses WHERE expenseID = ?";

    @Override
    public boolean create(Expense expense) throws SQLException {
        try (Connection conn = db.start()) {
            if (conn == null) {
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, expense.getTitle());
                ps.setString(2, expense.getNote());
                ps.setDouble(3, expense.getAmount());
                ps.setDate(4, expense.getDateIncurred());

                if (ps.executeUpdate() > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            expense.setId(rs.getInt(1));
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Expense read(int id) throws SQLException {
        try (Connection conn = db.start()) {
            if (conn == null) {
                return null;
            }

            try (PreparedStatement ps = conn.prepareStatement(READ)) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Expense(
                                rs.getInt("expenseID"),
                                rs.getString("title"),
                                rs.getString("note"),
                                rs.getDouble("amount"),
                                rs.getDate("dateIncurred")
                        );
                    }
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Expense> readAll() throws SQLException {
        ArrayList<Expense> expenses = new ArrayList<>();

        try (Connection conn = db.start()) {
            if (conn == null) {
                return expenses;
            }

            try (PreparedStatement ps = conn.prepareStatement(READ_ALL);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    expenses.add(new Expense(
                            rs.getInt("expenseID"),
                            rs.getString("title"),
                            rs.getString("note"),
                            rs.getDouble("amount"),
                            rs.getDate("dateIncurred")
                    ));
                }
            }
        }
        return expenses;
    }

    @Override
    public boolean update(int id, Expense newExp) throws SQLException {
        try (Connection conn = db.start()) {
            if (conn == null) {
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
                ps.setString(1, newExp.getTitle());
                ps.setString(2, newExp.getNote());
                ps.setDouble(3, newExp.getAmount());
                ps.setDate(4, newExp.getDateIncurred());
                ps.setInt(5, id);

                return ps.executeUpdate() > 0;
            }
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection conn = db.start()) {
            if (conn == null) {
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
                ps.setInt(1, id);
                return ps.executeUpdate() > 0;
            }
        }
    }
}
