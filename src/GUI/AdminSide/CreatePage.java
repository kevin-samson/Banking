package src.GUI.AdminSide;

import src.users.User;
import src.bank.BankManager;
import src.GUI.AdminPage;
import src.bank.Bank;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class CreatePage implements ActionListener {
    User u;
    JFrame frame = new JFrame();
    JLabel createuser = new JLabel("Create New User!");
    JLabel first = new JLabel("First Name: ");
    JLabel last = new JLabel("Last Name: ");
    JLabel emailid = new JLabel("Email : ");
    JLabel phno = new JLabel("Phone No : ");
    JLabel eid = new JLabel("Accound ID : ");
    JTextField firstname = new JTextField();
    JTextField lastname = new JTextField();
    JTextField email = new JTextField();
    JTextField phoneno = new JTextField();
    JTextField emiratesidno = new JTextField();
    JButton createbutton = new JButton("Create");
    JButton cancelbutton = new JButton("Cancel");
    BankManager bm;
    Bank b;

    public static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    public CreatePage(User u, Bank b, BankManager bm) {
        this.u = u;
        this.b = b;
        this.bm = bm;
        first.setBounds(50, 50, 75, 25);
        last.setBounds(50, 100, 75, 25);
        emailid.setBounds(50, 150, 75, 25);
        phno.setBounds(50, 200, 75, 25);
        eid.setBounds(50, 250, 75, 25);

        firstname.setBounds(150, 50, 150, 25);
        lastname.setBounds(150, 100, 150, 25);
        email.setBounds(150, 150, 150, 25);
        phoneno.setBounds(150, 200, 150, 25);
        emiratesidno.setBounds(150, 250, 150, 25);

        createbutton.setBounds(125, 300, 100, 25);
        createbutton.setFocusable(false);
        createbutton.addActionListener(this::actionPerformed);

        cancelbutton.setBounds(225, 300, 100, 25);
        cancelbutton.setFocusable(false);
        cancelbutton.addActionListener(this::actionPerformed);

        frame.add(firstname);
        frame.add(lastname);
        frame.add(email);
        frame.add(phoneno);
        frame.add(emiratesidno);
        frame.add(createbutton);
        frame.add(createuser);
        frame.add(cancelbutton);
        frame.add(first);
        frame.add(last);
        frame.add(emailid);
        frame.add(phno);
        frame.add(eid);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createbutton) {
            try {
                String first = firstname.getText();
                String last = lastname.getText();
                String email = this.email.getText();
                String phone = phoneno.getText();
                String AccountNumber = emiratesidno.getText();
                if (first.equals("") || last.equals("") || email.equals("") || phone.equals("")
                        || AccountNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter all details!");
                } else if (b.getUserByAccountId(Integer.parseInt(AccountNumber)) != null) {
                    JOptionPane.showMessageDialog(null, "User ID alredy exists!");
                    emiratesidno.setText("");
                } else if (!isValid(email)) {
                    JOptionPane.showMessageDialog(null, "Please enter valid email!");
                    this.email.setText("");
                } else if (phone.length() != 10) {
                    JOptionPane.showMessageDialog(null, "Please enter valid phone number!");
                    phoneno.setText("");
                } else if (AccountNumber.length() > 10) {
                    JOptionPane.showMessageDialog(null, "Please enter valid account number!");
                    emiratesidno.setText("");
                } else {
                    b.addUser(new User(first, last, email, Integer.parseInt(phone), Integer.parseInt(AccountNumber)));
                    bm.save(b);
                    JOptionPane.showMessageDialog(null, "User Created!");
                    frame.dispose();
                    new AdminPage(u, b, bm);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields with vaild details!");
            }
        }
        if (e.getSource() == cancelbutton) {
            frame.dispose();
            new AdminPage(u, b, bm);
        }
    }

}
