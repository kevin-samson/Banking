package src.GUI.UserSide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.bank.BankManager;
import src.bank.BackAccount;
import src.bank.Bank;
import src.users.User;

public class Withdraw extends JFrame implements ActionListener {
    User u;
    BankManager bm;
    Bank b;
    BackAccount ba;
    JFrame frame = new JFrame();
    JButton hund = new JButton("100 AED");
    JButton twohund = new JButton("250 AED");
    JButton fivehund = new JButton("500 AED");
    JButton thousand = new JButton("1000 AED");
    JButton enter = new JButton("Enter Manually");
    JButton back = new JButton("Back");

    public Withdraw(User u, BankManager bm, Bank b, BackAccount ba) {
        this.u = u;
        this.bm = bm;
        this.b = b;
        this.ba = ba;

        hund.setBounds(100, 50, 200, 25);
        hund.setFocusable(false);
        hund.addActionListener(this);

        twohund.setBounds(100, 100, 200, 25);
        twohund.setFocusable(false);
        twohund.addActionListener(this);

        fivehund.setBounds(100, 150, 200, 25);
        fivehund.setFocusable(false);
        fivehund.addActionListener(this);

        thousand.setBounds(100, 200, 200, 25);
        thousand.setFocusable(false);
        thousand.addActionListener(this);

        enter.setBounds(100, 250, 200, 25);
        enter.addActionListener(this);
        enter.setFocusable(false);

        back.setBounds(150, 300, 100, 25);
        back.addActionListener(this);
        back.setFocusable(false);

        frame.add(hund);
        frame.add(twohund);
        frame.add(fivehund);
        frame.add(thousand);
        frame.add(enter);
        frame.add(back);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
            new AccountPage(u, bm, b, ba);
        }

        if (e.getSource() == hund) {
            if (ba.getBalance() < 100) {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
            }
            ba.withdraw(100);
            bm.save(b);
            JOptionPane.showMessageDialog(null, "AED 100 has been withdrawn!");
            new AccountPage(u, bm, b, ba);
            frame.dispose();
        }

        if (e.getSource() == twohund) {
            if (ba.getBalance() < 250) {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
            } else {
                ba.withdraw(250);
                bm.save(b);
                JOptionPane.showMessageDialog(null, "AED 250 has been withdrawn!");
                new AccountPage(u, bm, b, ba);
                frame.dispose();
            }
        }

        if (e.getSource() == fivehund) {
            if (ba.getBalance() < 500) {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
            } else {
                ba.withdraw(500);
                bm.save(b);
                JOptionPane.showMessageDialog(null, "AED 500 has been withdrawn!");
                new AccountPage(u, bm, b, ba);
                frame.dispose();
            }
        }

        if (e.getSource() == thousand) {
            if (ba.getBalance() < 1000) {
                JOptionPane.showMessageDialog(null, "Insufficient funds!");
            } else {
                ba.withdraw(1000);
                bm.save(b);
                JOptionPane.showMessageDialog(null, "AED 1000 has been withdrawn!");
                new AccountPage(u, bm, b, ba);
                frame.dispose();
            }
        }

        if (e.getSource() == enter) {
            try {
                String amount = JOptionPane.showInputDialog("Enter amount to withdraw");
                double amt = Double.parseDouble(amount);
                if (amt > ba.getBalance()) {
                    JOptionPane.showMessageDialog(null, "Insufficient funds!");
                    new AccountPage(u, bm, b, ba);
                }
                ba.withdraw(amt);
                bm.save(b);
                JOptionPane.showMessageDialog(null, "AED " + amt + " has been withdrawn!");
                frame.dispose();
                new AccountPage(u, bm, b, ba);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
                new AccountPage(u, bm, b, ba);
            }
        }
    }
}