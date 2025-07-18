import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TransactionManager {
    private final TransactionFileHandler fileHandler = new TransactionFileHandler();
    private final TransactionService service = new TransactionService();
    private final Scanner scanner = new Scanner(System.in);

    private String inString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public void addTransaction(String username, boolean isDeposit) {
        String desc = inString("Description: ");
        String vendor = inString("Vendor: ");
        double amt = Double.parseDouble(inString("Amount: "));
        if (!isDeposit) amt = -Math.abs(amt);
        Transaction tx = new Transaction(username, LocalDate.now(), java.time.LocalTime.now(), desc, vendor, amt);
        fileHandler.save(tx);
        System.out.println("Transaction recorded.");
    }

    public void ledgerMenu(String username) {
        List<Transaction> all = fileHandler.load();
        while (true) {
            System.out.println("\n== LEDGER ==");
            System.out.println("A) Show Transactions\nD) Deposits\nP) Payments\nR) Reports\nH) Home");
            switch (inString("").trim().toUpperCase()) {
                case "A": service.display(all); break;
                case "D": service.display(service.filterDeposits(all)); break;
                case "P": service.display(service.filterPayments(all)); break;
                case "R": reportMenu(all); break;
                case "H": return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    public void reportMenu(List<Transaction> all) {
        while (true) {
            System.out.println("\n== REPORTS ==");
            System.out.println("1) Month to Date\n2) Previous Month\n3) Year to Date\n4) Previous Year\n5) Search by Vendor\n0) Back");
            String input = inString("");
            LocalDate now = LocalDate.now();
            switch (input) {
                case "1":
                    service.display(service.filterByDateRange(all, now.withDayOfMonth(1), now));
                    break;
                case "2":
                    LocalDate start = now.minusMonths(1).withDayOfMonth(1);
                    LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
                    service.display(service.filterByDateRange(all, start, end));
                    break;
                case "3":
                    service.display(service.filterByDateRange(all, now.withDayOfYear(1), now));
                    break;
                case "4":
                    LocalDate pyStart = now.minusYears(1).withDayOfYear(1);
                    LocalDate pyEnd = pyStart.withDayOfYear(pyStart.lengthOfYear());
                    service.display(service.filterByDateRange(all, pyStart, pyEnd));
                    break;
                case "5":
                    System.out.print("Vendor: ");
                    String vendor = inString("");
                    service.display(service.filterByVendor(all, vendor));
                    break;
                case "0": return;
                default: System.out.println("Invalid option.");
            }
        }
    }
}



