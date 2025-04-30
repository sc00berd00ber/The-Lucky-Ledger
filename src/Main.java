import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TransactionManager manager = new TransactionManager();

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        while (true) {
            System.out.println("\n== HOME ==");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Select: ");
            switch (scanner.nextLine().trim().toUpperCase()) {
                case "D": manager.addTransaction(true); break;
                case "P": manager.addTransaction(false); break;
                case "L": manager.ledgerMenu(); break;
                case "X": return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}

//    static void addTransaction(boolean isDeposit) {
//        System.out.print("Description: ");
//        String desc = scanner.nextLine();
//        System.out.print("Vendor: ");
//        String vendor = scanner.nextLine();
//        System.out.print("Amount: ");
//        double amt = Double.parseDouble(scanner.nextLine());
//        if (!isDeposit) amt = -Math.abs(amt);
//        Transaction tx = new Transaction(LocalDate.now(), LocalTime.now(), desc, vendor, amt);
//        manager.saveTransaction(tx);
//        System.out.println("Transaction recorded.");
//    }
//
//    static void showLedger() {
//        List<Transaction> all = manager.loadTransactions();
//        while (true) {
//            System.out.println("\n== LEDGER ==");
//            System.out.println("A) All");
//            System.out.println("D) Deposits");
//            System.out.println("P) Payments");
//            System.out.println("R) Reports");
//            System.out.println("H) Home");
//            System.out.print("Select: ");
//            String input = scanner.nextLine().trim().toUpperCase();
//            switch (input) {
//                case "A": manager.displayTransactions(all); break;
//                case "D": manager.displayTransactions(manager.filterDeposits(all)); break;
//                case "P": manager.displayTransactions(manager.filterPayments(all)); break;
//                case "R": showReports(all); break;
//                case "H": return;
//                default: System.out.println("Invalid choice.");
//            }
//        }
//    }
//
//    static void showReports(List<Transaction> all) {
//        while (true) {
//            System.out.println("\n== REPORTS ==");
//            System.out.println("1) Month to Date");
//            System.out.println("2) Previous Month");
//            System.out.println("3) Year to Date");
//            System.out.println("4) Previous Year");
//            System.out.println("5) Search by Vendor");
//            System.out.println("0) Back");
//            System.out.print("Select: ");
//            String input = scanner.nextLine().trim();
//            LocalDate now = LocalDate.now();
//            switch (input) {
//                case "1":
//                    manager.displayTransactions(
//                            manager.filterByDateRange(all,
//                                    now.withDayOfMonth(1), now));
//                    break;
//                case "2":
//                    LocalDate prevMonthStart = now.minusMonths(1).withDayOfMonth(1);
//                    LocalDate prevMonthEnd = prevMonthStart.withDayOfMonth(prevMonthStart.lengthOfMonth());
//                    manager.displayTransactions(manager.filterByDateRange(all, prevMonthStart, prevMonthEnd));
//                    break;
//                case "3":
//                    manager.displayTransactions(manager.filterByDateRange(all, now.withDayOfYear(1), now));
//                    break;
//                case "4":
//                    LocalDate prevYearStart = now.minusYears(1).withDayOfYear(1);
//                    LocalDate prevYearEnd = prevYearStart.withDayOfYear(prevYearStart.lengthOfYear());
//                    manager.displayTransactions(manager.filterByDateRange(all, prevYearStart, prevYearEnd));
//                    break;
//                case "5":
//                    System.out.print("Vendor name: ");
//                    String vendor = scanner.nextLine();
//                    manager.displayTransactions(manager.filterByVendor(all, vendor));
//                    break;
//                case "0": return;
//                default: System.out.println("Invalid input.");
//            }
//        }
//    }
}
