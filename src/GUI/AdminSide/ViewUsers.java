package src.GUI.AdminSide;

import javax.swing.*;
import src.users.User;
import src.bank.BankManager;
import src.bank.Bank;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.GUI.AdminPage;

public class ViewUsers implements ActionListener {
    JTable table = new JTable();
    JFrame frame = new JFrame();
    BankManager bm;
    Bank b;
    User u;
    JButton cancelbutton = new JButton("Cancel");

    public ViewUsers(User u, Bank b, BankManager bm) {
        this.u = u;
        this.b = b;
        this.bm = bm;
        frame = new JFrame();
        String[][] data = b.getAllUsers();
        String column[] = { "AccNo", "First Name", "Last Name", "EMail", "PhoneNo" };
        table = new JTable(data, column);
        table.setBounds(0, 75, 300, 300);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 75, 300, 300);
        cancelbutton.setSize(100, 25);
        cancelbutton.setFocusable(false);
        cancelbutton.addActionListener(this::actionPerformed);

        sp.add(cancelbutton);
        frame.add(sp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelbutton) {
            frame.dispose();
            new AdminPage(u, b, bm);
        }
    }
}
