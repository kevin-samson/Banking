import src.users.User;
import src.bank.BankManager;
import src.bank.Bank;
import java.util.Scanner;
import src.menus.AdminMenu;
import src.menus.UserMenu;

public class Testing {
    public static void main(String[] args) {
        BankManager bm = new BankManager();
        Bank b = bm.getBank();
        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to the bank");
        System.out.print("Enter the account number ");
        int id = scn.nextInt();
        User found = b.getUserByAccountId(id);
        if (found != null) {
            if (found.getPin() == 0) {
                System.out.println("You have not set a pin yet");
                System.out.print("Enter a pin ");
                int p = scn.nextInt();
                found.setPin(p);
                bm.save(b);
            }
            System.out.print("Enter the pin ");
            int pin = scn.nextInt();
            if (found.getPin() == pin) {
                if (id == 2003) {
                    int choice = 0;
                    while (choice != 4) {
                        System.out.println();
                        System.out.println("1. View all users");
                        System.out.println("2. Add user");
                        System.out.println("3. Delete user");
                        System.out.println("4. Logout");
                        System.out.print("Enter your choice ");
                        choice = scn.nextInt();
                        new AdminMenu(found, choice);
                    }
                } else {
                    int choice = 0;
                    while (choice != 4) {
                        System.out.println();
                        System.out.println("1. View all bank accounts");
                        System.out.println("2. Add bank account");
                        System.out.println("3. Delete bank account");
                        System.out.println("4. Logout");
                        System.out.print("Enter your choice ");
                        choice = scn.nextInt();
                        bm.save(b);
                        new UserMenu(found, choice);
                    }
                }
            } else {
                System.out.println("Incorrect pin");
            }
        } else {
            System.out.println("User not found");
        }

    }
}