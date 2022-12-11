package src.GUI;

import javax.swing.*;
import java.awt.*;
import src.users.User;
import src.bank.BankManager;
import src.GUI.AdminSide.CreatePage;
import src.bank.Bank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcome = new JLabel("Welcome Admin!");
    JButton view = new JButton("View all Users");
    JButton delete = new JButton("Delete User");
    JButton create = new JButton("Create new User");
    JButton logout = new JButton("Logout");
    User u;
    BankManager bm;
    Bank b;

    AdminPage(User u, Bank b, BankManager bm) {
        this.u = u;
        this.b = b;
        this.bm = bm;
        welcome.setBounds(100, -75, 250, 250);
        welcome.setFont(new Font("Roboto", Font.PLAIN, 25));

        view.setBounds(100, 100, 200, 25);
        view.setFocusable(false);

        delete.setBounds(100, 150, 200, 25);
        delete.setFocusable(false);

        create.setBounds(100, 200, 200, 25);
        create.setFocusable(false);
        create.addActionListener(this::actionPerformed);

        logout.setBounds(100, 250, 200, 25);
        logout.setFocusable(false);
        logout.addActionListener(this::actionPerformed);

        frame.add(welcome);
        frame.add(view);
        frame.add(delete);
        frame.add(create);
        frame.add(logout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            System.out.println("Logout");
            frame.dispose();
            new LoginPage();
        }

        if (e.getSource() == create) {
            System.out.println("Create");
            frame.dispose();
            new CreatePage(u, b, bm);
        }

    }
}