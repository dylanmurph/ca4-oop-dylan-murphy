package DTOs;

public class Income {
    private int incomeID;
    private String title;
    private String note;
    private double amount;
    private String dateEarned;

    public Income() {
    }

    public Income(int incomeID, String title, String note, double amount, String dateEarned) {
        this.incomeID = incomeID;
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    public Income(String title, String note, double amount, String dateEarned) {
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int incomeID) {
        this.incomeID = incomeID;
    }

    public int getId() {
        return incomeID;
    }

    public String getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
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
                incomeID, title, note, amount, dateEarned);
    }
}
