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

    // Get all transactions in a 2D array
    public String[][] getAllTransactions() {
        String[][] data = new String[history.size()][3];
        for (int i = 0; i < history.size(); i++) {
            data[i][0] = history.get(i).type;
            data[i][1] = Double.toString(history.get(i).amount);
            data[i][2] = history.get(i).t.toString();
        }
        return data;
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
