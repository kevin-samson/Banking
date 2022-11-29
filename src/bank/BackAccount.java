package src.bank;

import java.util.ArrayList;
import java.io.Serializable;

public class BackAccount implements Serializable {
    double balance;
    String accountType;
    ArrayList<TransHistory> history = new ArrayList<TransHistory>();

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
        history.add(new TransHistory("Deposit", amount));
    }

    public void showHistory() {
        if (history.size() == 0) {
            System.out.println("No transactions yet");
        } else {
            for (TransHistory t : history) {
                t.show();
            }
        }
    }

    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            history.add(new TransHistory("Withdraw", amount));
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
