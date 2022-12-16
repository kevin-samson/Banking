package src.users;

import src.bank.BackAccount;
import java.util.ArrayList;

public class User extends Person {
    public int accountNumber;
    int pinNumber = 0;
    ArrayList<BackAccount> bAccounts = new ArrayList<BackAccount>();

    public User(String firstName, String lastName, String email, int phoneNumber, int accountNumber) {
        super(firstName, lastName, email, phoneNumber);
        this.accountNumber = accountNumber;
    }

    public User(String firstName, String lastName, String email, int phoneNumber) {
        super(firstName, lastName, email, phoneNumber);
    }

    public void addBankAccount(BackAccount b) {
        bAccounts.add(b);
    }

    public void addBankAccount(String accountType, double balance) {
        bAccounts.add(new BackAccount(accountType, balance));
    }

    public void getAllBankAccounts() {
        int i = 1;
        if (bAccounts.size() == 0) {
            System.out.println("No bank accounts");
        } else {
            for (BackAccount b : bAccounts) {
                System.out.println(i + " " + b.getAccountType() + " " + b.getBalance() + "$");
                i++;
            }
        }
    }

    public BackAccount getBankAccount(int acc) {
        return bAccounts.get(acc - 1);
    }

    public void setPin(int p) {
        this.pinNumber = p;
    }

    public int getPin() {
        return pinNumber;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

}
