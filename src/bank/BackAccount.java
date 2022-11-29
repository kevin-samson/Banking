package src.bank;

import java.io.Serializable;

public class BackAccount implements Serializable {
    double balance;
    String accountType;

    public BackAccount(String accountType, double balance) {
        this.balance = balance;
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
