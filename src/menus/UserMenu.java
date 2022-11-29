package src.menus;

import src.bank.BackAccount;
import java.util.Scanner;
import src.users.User;

public class UserMenu {
    public UserMenu(User u, int choice) {
        Scanner scn = new Scanner(System.in);
        switch (choice) {
            case 1:
                System.out.println();
                u.getAllBankAccounts();
                System.out.println();
                System.out.println("1. Select an account to view");
                System.out.println("2. Go back");
                System.out.print("Enter your choice ");
                int c = scn.nextInt();
                if (c == 1) {
                    System.out.print("Enter the account number ");
                    int acc = scn.nextInt();
                    BackAccount ba = u.getBankAccount(acc);
                    System.out.println();
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. View transaction history");
                    System.out.println("4. Go back");
                    System.out.print("Enter your choice ");
                    int ch = scn.nextInt();
                    if (ch == 1) {
                        System.out.print("Enter the amount ");
                        double amount = scn.nextDouble();
                        ba.deposit(amount);

                    } else if (ch == 2) {
                        System.out.print("Enter the amount ");
                        double amount = scn.nextDouble();
                        ba.withdraw(amount);

                    } else if (ch == 3) {
                        ba.showHistory();
                    }

                }
                break;
            case 2:
                System.out.println();
                System.out.print("Enter the account type ");
                String accountType = scn.nextLine();
                System.out.print("Enter the balance ");
                double balance = scn.nextDouble();
                u.addBankAccount(accountType, balance);

                break;
            case 3:
                break;
            case 4:
                System.out.println("Logged out");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
