package src.bank;

import src.users.User;
import java.io.*;

public class BankManager extends Bank {
    Bank b = null;

    public BankManager() {
        try {
            FileInputStream fileIn = new FileInputStream("bank.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            b = (Bank) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println("No file found, creating new bank");
            b = new Bank();
            b.addUser(new User("Kevin", "Samson", "kevinsam2003@gmail.com", 567269454, 2003));
            try {
                FileOutputStream fileOut = new FileOutputStream("bank.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(b);
                out.close();
                fileOut.close();
                System.out.println("Data saved");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public Bank getBank() {
        return b;
    }

    public void save(Bank b) {
        try {
            FileOutputStream fileOut = new FileOutputStream("bank.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(b);
            out.close();
            fileOut.close();
            System.out.println("Data saved");
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
