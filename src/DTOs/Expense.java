package DTOs;

import java.sql.Date;

public class Expense {
    private int expenseID;
    private String title;
    private String note;
    private double amount;
    private Date dateIncurred;

    public Expense() {}

    public Expense(int expenseID, String title, String note, double amount, Date dateIncurred) {
        this.expenseID = expenseID;
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return expenseID;
    }

    public void setId(int expenseID) {
        this.expenseID = expenseID;
    }

    public Date getDateIncurred() {
        return dateIncurred;
    }

    public void setDateIncurred(Date dateIncurred) {
        this.dateIncurred = dateIncurred;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return String.format("Expense [ID: %d, Title: %s, Note: %s, Amount: %f, Date Incurred: %s]",
                expenseID, title, note, amount, dateIncurred);
    }
}
