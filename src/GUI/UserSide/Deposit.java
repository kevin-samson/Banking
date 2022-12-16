package src.GUI.UserSide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.GUI.LoginPage;

public class Deposit extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton hund = new JButton("100 AED");
    JButton fivehund = new JButton("500 AED");
    JButton thousand = new JButton("1000 AED");
    JButton fivethousand = new JButton("5000 AED");
    JButton enter = new JButton("Enter Manually");
    JButton logout = new JButton("Logout");

    Deposit() {
        hund.setBounds(100, 50, 200, 25);
        hund.setFocusable(false);

        fivehund.setBounds(100, 100, 200, 25);
        fivehund.setFocusable(false);

        thousand.setBounds(100, 150, 200, 25);
        thousand.setFocusable(false);

        fivethousand.setBounds(100, 200, 200, 25);
        fivethousand.setFocusable(false);

        enter.setBounds(100, 250, 200, 25);
        enter.addActionListener(this);
        enter.setFocusable(false);

        logout.setBounds(150, 300, 100, 25);
        logout.addActionListener(this);
        logout.setFocusable(false);

        frame.add(hund);
        frame.add(fivehund);
        frame.add(thousand);
        frame.add(fivethousand);
        frame.add(enter);
        frame.add(logout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            new LoginPage();
            frame.dispose();
        }
        if (e.getSource() == enter) {
            int amount = Integer.parseInt(JOptionPane.showInputDialog("Enter Amount to Deposit: "));
            JOptionPane.showMessageDialog(null, "AED " + amount + " Deposited");
            frame.dispose();
        }
    }
}