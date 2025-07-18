import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileHandler {
    String fileName = "transactions.csv";

    //Reads from csv file
    public List<Transaction> load() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().startsWith("date"))
                    continue;
                try {
                    transactions.add(Transaction.fromCSV(line));
                } catch (Exception e) {
                    System.out.println("Skipping malformed transaction line: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read file!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
        return transactions;
    }

    //Writes to csv file
    public void save(Transaction tx) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(tx.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }
}