package src.GUI.UserSide;

import src.users.User;
import javax.swing.*;
import java.awt.*;
import src.bank.BankManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.bank.BackAccount;
import src.GUI.UserPage;
import src.bank.Bank;

public class AccountPage implements ActionListener {
    User u;
    BankManager bm;
    Bank b;
    BackAccount ba;
    JFrame frame = new JFrame();
    JLabel welcome = new JLabel("Account Page");
    JButton withdraw = new JButton("Withdraw");
    JButton deposit = new JButton("Deposit");
    JButton viewt = new JButton("View Transactions");
    JButton back = new JButton("Back");

    public AccountPage(User u, BankManager bm, Bank b, BackAccount ba) {
        this.u = u;
        this.bm = bm;
        this.b = b;
        this.ba = ba;

        welcome.setBounds(125, -110, 250, 250);
        welcome.setText(ba.getAccountType());
        welcome.setFont(new Font("Roboto", Font.PLAIN, 25));
        welcome.setFocusable(false);
        frame.add(welcome);

        JLabel balance = new JLabel("Balance: " + ba.getBalance());
        balance.setBounds(100, 50, 200, 25);
        balance.setFont(new Font("Roboto", Font.PLAIN, 15));
        balance.setFocusable(false);
        frame.add(balance);

        withdraw.setBounds(100, 100, 100, 25);
        withdraw.setFocusable(false);
        withdraw.addActionListener(this::actionPerformed);
        frame.add(withdraw);

        deposit.setBounds(100, 150, 100, 25);
        deposit.setFocusable(false);
        deposit.addActionListener(this::actionPerformed);
        frame.add(deposit);

        viewt.setBounds(100, 200, 150, 25);
        viewt.setFocusable(false);
        viewt.addActionListener(this::actionPerformed);
        frame.add(viewt);

        back.setBounds(100, 250, 100, 25);
        back.setFocusable(false);
        back.addActionListener(this::actionPerformed);
        frame.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            frame.dispose();
            new Withdraw(u, bm, b, ba);
        }

        if (e.getSource() == back) {
            frame.dispose();
            new UserPage(u, bm, b);
        }

        if (e.getSource() == deposit) {
            frame.dispose();
            new Deposit(u, bm, b, ba);
        }
    }
}
