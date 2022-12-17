package src.GUI;

import javax.swing.*;
import java.awt.*;
import src.users.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.GUI.UserSide.*;
import src.bank.BankManager;
import src.bank.Bank;

public class UserPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcome = new JLabel("Welcome!");
    JButton view = new JButton("View all Bank Accounts");
    JButton delete = new JButton("Modify Account");
    JButton create = new JButton("Add Bank Account");
    JButton logout = new JButton("Logout");
    User u;
    BankManager bm;
    Bank b;

    public UserPage() {
        welcome.setBounds(100, -75, 250, 250);
        welcome.setFont(new Font("Roboto", Font.PLAIN, 25));

        view.setBounds(100, 100, 200, 25);
        view.setFocusable(false);
        view.addActionListener(this);

        delete.setBounds(100, 150, 200, 25);
        delete.setFocusable(false);
        delete.addActionListener(this);

        create.setBounds(100, 200, 200, 25);
        create.setFocusable(false);
        create.addActionListener(this);

        logout.setBounds(100, 250, 200, 25);
        logout.setFocusable(false);
        logout.addActionListener(this);

        frame.add(welcome);
        frame.add(view);
        frame.add(create);
        frame.add(delete);
        frame.add(logout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public UserPage(User u, BankManager bm, Bank b) {
        this();
        this.u = u;
        this.bm = bm;
        this.b = b;
        welcome.setText("Welcome " + u.getName() + "!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view) {
            new ViewBankAccounts(u, bm, b);
            frame.dispose();
        }
        if (e.getSource() == delete) {
            new ModifyDetails(u, b, bm);
            frame.dispose();
        }

        if (e.getSource() == create) {
            String accType = JOptionPane.showInputDialog("Enter the account name: ");
            try {
                double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter the initial balance: "));
                if (accType != null && balance != 0) {
                    u.addBankAccount(accType, balance);
                    bm.save(b);
                    JOptionPane.showMessageDialog(null, "Account created successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Account creation failed!");
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }

        if (e.getSource() == logout) {
            new LoginPage();
            frame.dispose();
        }
    }
}
