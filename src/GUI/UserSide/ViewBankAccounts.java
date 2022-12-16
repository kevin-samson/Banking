package src.GUI.UserSide;

import src.GUI.UserPage;
import src.users.User;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.GUI.LoginPage;
import src.bank.BankManager;
import src.bank.Bank;

public class ViewBankAccounts extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton view = new JButton("View Accounts");
    JButton select = new JButton("Select Account");
    JButton withdraw = new JButton("Withdraw");
    JButton deposit = new JButton("Deposit");
    JButton viewt = new JButton("View Transactions");
    JButton back = new JButton("Back");
    JButton logout = new JButton("Logout");
    User u;
    BankManager bm;
    Bank b;

    public ViewBankAccounts() {
        view.setBounds(100, 50, 200, 25);
        view.setFocusable(false);

        select.setBounds(100, 100, 200, 25);
        select.setFocusable(false);

        withdraw.setBounds(100, 150, 200, 25);
        withdraw.addActionListener(this);
        withdraw.setFocusable(false);

        deposit.setBounds(100, 200, 200, 25);
        deposit.addActionListener(this);
        deposit.setFocusable(false);

        viewt.setBounds(100, 250, 200, 25);
        viewt.setFocusable(false);

        back.setBounds(100, 300, 100, 25);
        back.addActionListener(this);
        back.setFocusable(false);

        logout.setBounds(200, 300, 100, 25);
        logout.addActionListener(this);
        logout.setFocusable(false);

        frame.add(view);
        frame.add(select);
        frame.add(withdraw);
        frame.add(deposit);
        frame.add(viewt);
        frame.add(back);
        frame.add(logout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public ViewBankAccounts(User u, BankManager bm, Bank b) {
        this();
        this.u = u;
        this.bm = bm;
        this.b = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            new LoginPage();
            frame.dispose();
        }
        if (e.getSource() == back) {
            new UserPage(u, bm, b);
            frame.dispose();
        }
        if (e.getSource() == withdraw) {
            new Withdraw();
            frame.dispose();
        }
        if (e.getSource() == deposit) {
            new Deposit();
            frame.dispose();
        }
    }
}