import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private final LocalDate date;
    private final LocalTime time;
    private final String description;
    private final String vendor;
    private final double amount;

    //Constructor
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    //Getters
    public LocalDate getDate() { return date; }
    public double getAmount() { return amount; }
    public String getVendor() { return vendor; }

    //Parser
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

    public String toCSV() {
        return String.format("%s | %s | %s | %s | %.2f", date, time, description, vendor, amount);
    }

    //Display override
    public String toString() {
        return toCSV();
    }
}