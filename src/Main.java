import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TransactionManager manager = new TransactionManager();

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        while (true) {
            System.out.println("\n=*=*=*=*=*=*=*=*=*=*=*=*=*== HOME =*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("[D] Add Deposit");
            System.out.println("[P] Make Payment");
            System.out.println("[L] Ledger");
            System.out.println("[X] Exit");
            System.out.print("Select: ");
            switch (scanner.nextLine().trim().toUpperCase()) {
                case "D": manager.addTransaction(true);
                break;
                case "P": manager.addTransaction(false);
                break;
                case "L": manager.ledgerMenu();
                break;
                case "X":
                    return;
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }
}