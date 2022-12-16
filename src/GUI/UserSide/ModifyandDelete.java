package src.GUI.UserSide;

import src.users.User;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.bank.BankManager;
import src.bank.Bank;

public class ModifyandDelete extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JButton modifybutton = new JButton("Modify");
    JButton deletebutton = new JButton("Delete");
    User u;
    BankManager bm;
    Bank b;

    ModifyandDelete() {

        // for Admin and User
        modifybutton.setBounds(100, 150, 200, 25);
        modifybutton.addActionListener(this);
        modifybutton.setFocusable(false);

        deletebutton.setBounds(100, 200, 200, 25);
        deletebutton.addActionListener(this);
        deletebutton.setFocusable(false);

        frame.add(modifybutton);
        frame.add(deletebutton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public ModifyandDelete(User u, Bank b, BankManager bm) {
        this();
        this.u = u;
        this.b = b;
        this.bm = bm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == modifybutton) {
            new ModifyDetails(u, b, bm);
            frame.dispose();
        }
        if (e.getSource() == deletebutton) {
            String name = JOptionPane.showInputDialog("Enter Account number to be deleted:");
            JOptionPane.showMessageDialog(null, "Account No " + name + " Deleted");
            frame.dispose();
        }
    }
}