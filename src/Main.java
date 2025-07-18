import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TransactionManager manager = new TransactionManager();
    private static final UserManager userManager = new UserManager();
    private User currentUser = null;

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        while (true) {
            System.out.println("\n== HOME ==");
            if (currentUser == null) {
                System.out.println("R) Register");
                System.out.println("I) Login");
            } else {
                System.out.println("D) Add Deposit");
                System.out.println("P) Make Payment");
                System.out.println("L) Ledger");
                System.out.println("O) Logout");
            }
            System.out.println("X) Exit");
            System.out.print("Select: ");
            String choice = scanner.nextLine().trim().toUpperCase();
            if (currentUser == null) {
                switch (choice) {
                    case "R":
                        System.out.print("Enter username: ");
                        String regUser = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String regPass = scanner.nextLine();
                        if (userManager.register(regUser, regPass)) {
                            System.out.println("Registration successful. You can now login.");
                        } else {
                            System.out.println("Username already exists.");
                        }
                        break;
                    case "I":
                        System.out.print("Enter username: ");
                        String logUser = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String logPass = scanner.nextLine();
                        User user = userManager.login(logUser, logPass);
                        if (user != null) {
                            currentUser = user;
                            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
                        } else {
                            System.out.println("Invalid credentials.");
                        }
                        break;
                    case "X":
                        return;
                    default:
                        System.out.println("Invalid choice. Try again!");
                }
            } else {
                switch (choice) {
                    case "D": manager.addTransaction(currentUser.getUsername(), true);
                    break;
                    case "P": manager.addTransaction(currentUser.getUsername(), false);
                    break;
                    case "L": manager.ledgerMenu(currentUser.getUsername());
                    break;
                    case "O":
                        currentUser = null;
                        System.out.println("Logged out.");
                        break;
                    case "X":
                        return;
                    default:
                        System.out.println("Invalid choice. Try again!");
                }
            }
        }
    }
}