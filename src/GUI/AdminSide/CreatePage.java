package src.GUI.AdminSide;

import src.users.User;
import src.bank.BankManager;
import src.GUI.LoginPage;
import src.bank.Bank;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    JTextField lastname = new JPasswordField();
    JTextField email = new JTextField();
    JTextField phoneno = new JTextField();
    JTextField emiratesidno = new JTextField();
    JButton createbutton = new JButton("Create");
    JButton cancelbutton = new JButton("Cancel");
    BankManager bm;
    Bank b;

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
            String first = firstname.getText();
            String last = lastname.getText();
            String email = this.email.getText();
            String phone = phoneno.getText();
            String AccountNumber = emiratesidno.getText();

            if (b.getUserByAccountId(Integer.parseInt(AccountNumber)) == null) {
                b.addUser(new User(first, last, email, Integer.parseInt(phone), Integer.parseInt(AccountNumber)));
                bm.save(b);
            } else {
                createuser.setText("User already exists!");
                emiratesidno.setText("");
            }
            frame.dispose();
            new LoginPage();
        }
        if (e.getSource() == cancelbutton) {
            frame.dispose();
            new LoginPage();
        }
    }

}
