package DAOs;

import DTOs.Income;
import java.sql.SQLException;
import java.util.List;

public interface IncomeDAOInterface {
    boolean create(Income income) throws SQLException;

    Income read(int id) throws SQLException;

    List<Income> readAll() throws SQLException;

    boolean update(int id, Income newInc) throws SQLException;

    boolean delete(int id) throws SQLException;
}
