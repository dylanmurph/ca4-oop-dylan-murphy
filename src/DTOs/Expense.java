package DTOs;

import Util.ColourUtil;

public class Expense {
    private int id;
    private String title;
    private String note;
    private double amount;
    private String date;

    public Expense() {
    }

    public Expense(int id, String title, String note, double amount, String date) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.date = date;
    }

    public Expense(String title, String note, double amount, String date) {
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return String.format(ColourUtil.yellow("Expense ID: %d\nTitle: %s\nNote: %s\nAmount: %f\nDate Incurred: %s"),
                id, title, note, amount, date);
    }
}
