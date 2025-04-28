import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //Home Screen
        System.out.println("------Main Menu------");
        System.out.println("'D' - Add Deposit");
        System.out.println("'P' - Make Payment (Debit)");
        System.out.println("'L' - Display Ledger Screen");
        System.out.println("'X' - Exit");
        String choice = input.nextLine();

        switch (choice){
            case "D":
            case "P":
            case "L":
            case "X":
                break;
            default:
                System.out.println("Invalid Entry. Please try again!");
        }
    }
}