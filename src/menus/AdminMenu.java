package src.menus;

import java.util.Scanner;
import src.users.User;
import src.bank.BankManager;
import src.bank.Bank;

public class AdminMenu {
    public AdminMenu(User u, int choice) {
        BankManager bm = new BankManager();
        Bank b = bm.getBank();

        Scanner scn = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println();
                b.getAllUsers();
                break;
            case 2:
                System.out.print("Enter the first name ");
                String firstName = scn.next();
                System.out.print("Enter the last name ");
                String lastName = scn.next();
                System.out.print("Enter the email ");
                String email = scn.next();
                System.out.print("Enter the phone number ");
                int phoneNumber = scn.nextInt();
                System.out.print("Enter the account number ");
                int accountNumber = scn.nextInt();
                if (b.getUserByAccountId(accountNumber) == null) {
                    b.addUser(new User(firstName, lastName, email, phoneNumber, accountNumber));
                    bm.save(b);
                } else {
                    System.out.println("User already exists");
                }
                break;
            case 3:
                System.out.println("Enter the account number");
                int id = scn.nextInt();
                b.deleteUser(id);
                bm.save(b);
                break;
            case 4:
                System.out.println("Logout");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
