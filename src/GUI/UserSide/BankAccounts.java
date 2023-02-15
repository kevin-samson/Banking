package src.GUI.UserSide;

import src.users.User;
import javax.swing.*;
import java.awt.*;
import src.bank.BankManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import src.bank.BackAccount;

import src.GUI.UserPage;
import src.bank.Bank;

public class BankAccounts implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcome = new JLabel("Select Account");
    JButton cancelbutton = new JButton("Cancel");
    User u;
    BankManager bm;
    Bank b;
    ArrayList<BackAccount> bAccounts;

    public BankAccounts(User u, BankManager bm, Bank b) {
        this.u = u;
        this.bm = bm;
        this.b = b;
        bAccounts = u.getBankAccounts();
        welcome.setBounds(125, -110, 250, 250);
        welcome.setFont(new Font("Roboto", Font.PLAIN, 25));

        // A for loop that creates a list of all the bank accounts
        for (int i = 0; i < bAccounts.size(); i++) {
            JLabel acc = new JLabel(bAccounts.get(i).getBalance() + " AED");
            JLabel sno = new JLabel((i + 1) + ")");
            JButton select = new JButton(bAccounts.get(i).getAccountType());
            acc.setBounds(250, 50 + (i * 50), 200, 25); // 100, 50 + (i * 50), 200, 25
            acc.setFont(new Font("Roboto", Font.PLAIN, 15));
            acc.setFocusable(false);

            sno.setBounds(50, 50 + (i * 50), 200, 25);
            sno.setFont(new Font("Roboto", Font.PLAIN, 15));
            sno.setFocusable(false);

            select.setBounds(100, 50 + (i * 50), 100, 25);
            select.setFocusable(false);
            select.addActionListener(this::actionPerformed);

            frame.add(sno);
            frame.add(acc);
            frame.add(select);
        }

        cancelbutton.setBounds(225, 300, 100, 25);
        cancelbutton.setFocusable(false);
        cancelbutton.addActionListener(this::actionPerformed);

        frame.add(welcome);
        frame.add(cancelbutton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelbutton) {
            frame.dispose();
            new UserPage(u, bm, b);
        }

        // A for loop that checks which button was pressed and opens the account page by
        // cheacking the account number
        for (int i = 0; i < u.getBankAccounts().size(); i++) {
            if (e.getActionCommand().equals(bAccounts.get(i).getAccountType())) {
                frame.dispose();
                new AccountPage(u, bm, b, u.getBankAccounts().get(i));
            }
        }
    }

}
