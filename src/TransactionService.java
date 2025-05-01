import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionService {

    //Filter logic
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
