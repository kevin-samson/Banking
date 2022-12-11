package src.GUI;

import javax.swing.*;
import java.awt.*;
import src.users.User;

public class UserPage {
    JFrame frame = new JFrame();
    JLabel welcome = new JLabel("Welcome!");
    JButton view = new JButton("View all Bank Accounts");
    JButton delete = new JButton("Modify Account");
    JButton create = new JButton("Add Bank Account");
    JButton logout = new JButton("Logout");
    User u;

    UserPage(User u) {
        this.u = u;
        welcome.setBounds(130, -75, 250, 250);
        welcome.setFont(new Font("Roboto", Font.PLAIN, 25));

        view.setBounds(100, 100, 200, 25);
        view.setFocusable(false);

        delete.setBounds(100, 150, 200, 25);
        delete.setFocusable(false);

        create.setBounds(100, 200, 200, 25);
        create.setFocusable(false);

        logout.setBounds(100, 250, 200, 25);
        logout.setFocusable(false);

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
}
