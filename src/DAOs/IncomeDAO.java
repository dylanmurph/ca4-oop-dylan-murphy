package DAOs;

import DTOs.Income;
import Database.DbConnect;

import java.sql.*;
import java.util.ArrayList;

public class IncomeDAO implements IncomeDAOInterface {
    private final DbConnect db = new DbConnect("jdbc:mysql://localhost/", "accounts_tracker", "root", "");

    private static final String CREATE = "INSERT INTO income (title, note, amount, dateEarned) VALUES (?, ?, ?, ?)";
    private static final String READ = "SELECT * FROM income WHERE incomeID = ?";
    private static final String READ_ALL = "SELECT * FROM income";
    private static final String UPDATE = "UPDATE income SET title = ?, note = ?, amount = ?, dateEarned = ? WHERE incomeID = ?";
    private static final String DELETE = "DELETE FROM income WHERE incomeID = ?";

    @Override
    public boolean create(Income income) throws SQLException {
        try (Connection conn = db.start()) {
            if (conn == null) {
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, income.getTitle());
                ps.setString(2, income.getNote());
                ps.setDouble(3, income.getAmount());
                ps.setString(4, income.getDateEarned());

                if (ps.executeUpdate() > 0) {
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            income.setId(rs.getInt(1));
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Income read(int id) throws SQLException {
        try (Connection conn = db.start()) {
            if (conn == null) {
                return null;
            }

            try (PreparedStatement ps = conn.prepareStatement(READ)) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Income(
                                rs.getInt("incomeID"),
                                rs.getString("title"),
                                rs.getString("note"),
                                rs.getDouble("amount"),
                                rs.getString("dateEarned")
                        );
                    }
                }
            }
        }
        return null;
    }


    @Override
    public ArrayList<Income> readAll() throws SQLException {
        ArrayList<Income> income = new ArrayList<>();

        try (Connection conn = db.start()) {
            if (conn == null) {
                return income;
            }

            try (PreparedStatement ps = conn.prepareStatement(READ_ALL);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    income.add(new Income(
                            rs.getInt("incomeID"),
                            rs.getString("title"),
                            rs.getString("note"),
                            rs.getDouble("amount"),
                            rs.getString("dateEarned")
                    ));
                }
            }
        }
        return income;
    }

    @Override
    public boolean update(int id, Income newInc) throws SQLException {
        try (Connection conn = db.start()) {
            if (conn == null) {
                return false;
            }

            try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
                ps.setString(1, newInc.getTitle());
                ps.setString(2, newInc.getNote());
                ps.setDouble(3, newInc.getAmount());
                ps.setString(4, newInc.getDateEarned());
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
