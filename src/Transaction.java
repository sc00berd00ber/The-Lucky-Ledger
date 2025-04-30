import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    //Constructor
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

//    //Parser
    public static Transaction fromCSV(String line) {
        String[] parts = line.split("\\|");
        return new Transaction(
                LocalDate.parse(parts[0].trim()),
                LocalTime.parse(parts[1].trim()),
                parts[2].trim(),
                parts[3].trim(),
                Double.parseDouble(parts[4].trim())
        );
    }

    //Getters
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getVendor() { return vendor; }

    // Setters
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String toCSV() {
        return String.format("%s | %s | %s | %s | %.2f", date, time, description, vendor, amount);
    }

    //Display override
    public String toString() {
        return String.format("%s | %s | %s | %s | %.2f", date, time, description, vendor, amount);
    }
}