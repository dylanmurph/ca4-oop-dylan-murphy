package DAOs;

import DTOs.Expense;

import java.sql.SQLException;
import java.util.List;

public interface ExpenseDAOInterface {
    boolean create(Expense expense) throws SQLException;

    Expense read(int id) throws SQLException;

    List<Expense> readAll() throws SQLException;

    boolean update(int id, Expense newExp) throws SQLException;

    boolean delete(int id) throws SQLException;

    List<Expense> readByMonth(int month) throws SQLException;
}
