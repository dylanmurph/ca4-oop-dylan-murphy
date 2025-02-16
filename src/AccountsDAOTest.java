import DAOs.ExpenseDAO;
import DAOs.IncomeDAO;
import DTOs.Expense;
import DTOs.Income;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

class AccountsDAOTest {
    private final IncomeDAO incomeDAO = new IncomeDAO();
    private final ExpenseDAO expenseDAO = new ExpenseDAO();


    @Test
    void testCreateIncome() throws SQLException {
        Income testIncome = new Income(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(incomeDAO.create(testIncome));
        assertTrue(testIncome.getId() > 0);
    }

    @Test
    void testReadIncome() throws SQLException {
        Income testIncome = new Income(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(incomeDAO.create(testIncome));

        Income income = incomeDAO.read(testIncome.getId());
        assertNotNull(income);
        assertEquals("Test Title", income.getTitle());
        assertEquals("Test Note", income.getNote());
        assertEquals(100.00, income.getAmount());
        assertEquals("2000-01-01", income.getDate());
    }

    @Test
    void testUpdateIncome() throws SQLException {
        Income testIncome = new Income(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(incomeDAO.create(testIncome));

        Income updatedIncome = new Income(0, "Updated Test Title", "Updated Test Note", 150.00, "2001-02-02");
        assertTrue(incomeDAO.update(testIncome.getId(), updatedIncome));

        Income income = incomeDAO.read(testIncome.getId());
        assertNotNull(income);
        assertEquals("Updated Test Title", income.getTitle());
        assertEquals("Updated Test Note", income.getNote());
        assertEquals(150.00, income.getAmount());
        assertEquals("2001-02-02", income.getDate());
    }

    @Test
    void testDeleteIncome() throws SQLException {
        Income testIncome = new Income(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(incomeDAO.create(testIncome));

        assertTrue(incomeDAO.delete(testIncome.getId()));
        assertNull(incomeDAO.read(testIncome.getId()));
    }

    @Test
    void testCreateExpense() throws SQLException {
        Expense testExpense = new Expense(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(expenseDAO.create(testExpense));
        assertTrue(testExpense.getId() > 0);
    }

    @Test
    void testReadExpense() throws SQLException {
        Expense testExpense = new Expense(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(expenseDAO.create(testExpense));

        Expense expense = expenseDAO.read(testExpense.getId());
        assertNotNull(expense);
        assertEquals("Test Title", expense.getTitle());
        assertEquals("Test Note", expense.getNote());
        assertEquals(100.00, expense.getAmount());
        assertEquals("2000-01-01", expense.getDate());
    }

    @Test
    void testUpdateExpense() throws SQLException {
        Expense testExpense = new Expense(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(expenseDAO.create(testExpense));

        Expense updatedExpense = new Expense(0, "Updated Test Title", "Updated Test Note", 150.00, "2001-02-02");
        assertTrue(expenseDAO.update(testExpense.getId(), updatedExpense));

        Expense expense = expenseDAO.read(testExpense.getId());
        assertNotNull(expense);
        assertEquals("Updated Test Title", expense.getTitle());
        assertEquals("Updated Test Note", expense.getNote());
        assertEquals(150.00, expense.getAmount());
        assertEquals("2001-02-02", expense.getDate());
    }

    @Test
    void testDeleteExpense() throws SQLException {
        Expense testExpense = new Expense(0, "Test Title", "Test Note", 100.00, "2000-01-01");
        assertTrue(expenseDAO.create(testExpense));

        assertTrue(expenseDAO.delete(testExpense.getId()));
        assertNull(expenseDAO.read(testExpense.getId()));
    }
}