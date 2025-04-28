import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionManager {
    private static final String FILE = "transactions.csv";

    public List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                transactions.add(Transaction.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return transactions;
    }

    public void saveTransaction(Transaction tx) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            writer.write(tx.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void displayTransactions(List<Transaction> txList) {
        txList.stream()
                .sorted(Comparator.comparing(Transaction::getDate).reversed())
                .forEach(System.out::println);
    }

    public List<Transaction> filterDeposits(List<Transaction> txs) {
        return txs.stream().filter(tx -> tx.getAmount() > 0).collect(Collectors.toList());
    }

    public List<Transaction> filterPayments(List<Transaction> txs) {
        return txs.stream().filter(tx -> tx.getAmount() < 0).collect(Collectors.toList());
    }

    public List<Transaction> filterByVendor(List<Transaction> txs, String vendor) {
        return txs.stream().filter(tx -> tx.getVendor().equalsIgnoreCase(vendor)).collect(Collectors.toList());
    }

    public List<Transaction> filterByDateRange(List<Transaction> txs, LocalDate from, LocalDate to) {
        return txs.stream().filter(tx -> !tx.getDate().isBefore(from) && !tx.getDate().isAfter(to)).collect(Collectors.toList());
    }
}
