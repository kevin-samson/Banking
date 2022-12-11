package src.GUI;

import src.bank.BankManager;
import src.bank.Bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import src.users.User;

public class LoginPage implements ActionListener {

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();
    JPasswordField userPassordfield = new JPasswordField();
    JLabel accLabel = new JLabel("Account No: ");
    JLabel pswdLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> logininfo = new HashMap<String, String>();
    BankManager bm = new BankManager();
    Bank b = bm.getBank();

    public LoginPage() {

        accLabel.setBounds(50, 100, 75, 25);
        pswdLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 200, 250, 250);
        messageLabel.setFont(new Font("Roboto", Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPassordfield.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this::actionPerformed);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this::actionPerformed);

        frame.add(accLabel);
        frame.add(pswdLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPassordfield);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            userIDField.setText("");
            userPassordfield.setText("");
        }
        if (e.getSource() == loginButton) {
            User u = null;
            String userId = userIDField.getText();
            String password = String.valueOf(userPassordfield.getPassword());
            int uid = 0;
            int pin = 0;
            try {
                uid = Integer.parseInt(userId);
                pin = Integer.parseInt(password);
                u = b.getUserByAccountId(uid);
            } catch (Exception ex) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Invalid Input");
            }
            if (u != null) {
                if (u.getPin() == 0) {
                    int p = Integer.parseInt(JOptionPane.showInputDialog("Please enter your new pin"));
                    u.setPin(p);
                    bm.save(b);
                }
                if (u.getPin() == pin) {
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    if (uid == 2003) {
                        new AdminPage(u, b, bm);
                        frame.dispose();
                    } else {
                        new UserPage(u);
                        frame.dispose();
                    }
                } else {
                    messageLabel.setForeground((Color.red));
                    messageLabel.setText("Wrong Password");
                }
            } else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }
        }
    }
}
