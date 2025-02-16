package DTOs;

public class Income {
    private int id;
    private String title;
    private String note;
    private double amount;
    private String date;

    public Income() {
    }

    public Income(int id, String title, String note, double amount, String date) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.date = date;
    }

    public Income(String title, String note, double amount, String date) {
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
        return String.format("Income [ID: %d, Title: %s, Note: %s, Amount: %f, Date Earned: %s]",
                id, title, note, amount, date);
    }
}
