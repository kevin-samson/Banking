package src.GUI.UserSide;

import javax.swing.*;
import src.users.User;
import src.bank.BankManager;
import src.bank.Bank;
import src.bank.BackAccount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class History implements ActionListener {
    JTable table = new JTable();
    JFrame frame = new JFrame();
    BankManager bm;
    Bank b;
    User u;
    BackAccount ba;
    JButton cancelbutton = new JButton("Cancel");

    public History(User u, BankManager bm, Bank b, BackAccount ba) {
        this.u = u;
        this.b = b;
        this.bm = bm;
        this.ba = ba;
        frame = new JFrame();
        String[][] data = ba.getAllTransactions();
        String column[] = { "Type", "Amount", "Date" };
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
            new AccountPage(u, bm, b, ba);
        }
    }
}
