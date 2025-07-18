import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private final LocalDate date;
    private final LocalTime time;
    private final String description;
    private final String vendor;
    private final double amount;
    private String username;

    //Constructor
    public Transaction(String username, LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.username = username;
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
    public String getUsername() {
        return username;
    }

    //Parser
    public static Transaction fromCSV(String line) {
        String[] parts = line.split("\\|");
        if (parts.length != 6) {
            throw new IllegalArgumentException("Malformed transaction line: " + line);
        }
        String username = parts[0].trim();
        // Optionally, add more checks for username validity here
        LocalDate date = LocalDate.parse(parts[1].trim());
        LocalTime time = LocalTime.parse(parts[2].trim());
        String description = parts[3].trim();
        String vendor = parts[4].trim();
        double amount = Double.parseDouble(parts[5].trim());
        return new Transaction(username, date, time, description, vendor, amount);
    }

    public String toCSV() {
        return String.format("%s | %s | %s | %s | %s | %.2f", username, date, time, description, vendor, amount);
    }

    //Display override
    public String toString() {
        return String.format("%s | %s | %s | %.2f | %s", username, date, description, amount, vendor);
    }
}