package src.GUI.AdminSide;

import javax.swing.*;
import src.users.User;
import src.bank.BankManager;
import src.bank.Bank;

public class DeleteUser {
    BankManager bm;
    Bank b;
    User u;

    public DeleteUser(User u, Bank b, BankManager bm) {
        this.bm = bm;
        this.b = b;
        this.u = u;

        String name = JOptionPane.showInputDialog("Enter Account number to be deleted:");
        if (name != null) {
            try {
                int accountNumber = Integer.parseInt(name);
                if (accountNumber == 2003) {
                    JOptionPane.showMessageDialog(null, "Cannot delete admin");
                } else if (b.getUserByAccountId(accountNumber) == null) {
                    JOptionPane.showMessageDialog(null, "User does not exist");

                } else {
                    b.deleteUser(accountNumber);
                    bm.save(b);
                    JOptionPane.showMessageDialog(null, "User deleted");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid Account Number");
            }
        }

    }
}
