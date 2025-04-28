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
    public static Transaction fromCSV(String line) {
        String[] parts = line.split("\\|");
        return new Transaction(
                LocalDate.parse(parts[0]),
                LocalTime.parse(parts[1]),
                parts[2],
                parts[3],
                Double.parseDouble(parts[4])
        );
    }

    public String toCSV() {
        return String.format("%s|%s|%s|%s|%.2f", date, time, description, vendor, amount);
    }
    //Getters
    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }
    public String getVendor() { return vendor; }

    public String toString() {
        return String.format("%s | %s | %s | %s | %.2f", date, time, description, vendor, amount);
    }
}