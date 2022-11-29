import java.io.*;
import src.bank.Bank;
import src.users.User;

public class Read {
    public static void main(String[] args) {
        Bank b = null;
        try {
            FileInputStream fileIn = new FileInputStream("bank.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            b = (Bank) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Loaded bank");
        } catch (Exception e) {
            System.out.println("No file found, creating new bank");
            b = new Bank();
            try {
                FileOutputStream fileOut = new FileOutputStream("bank.ser");
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(b);
                out.close();
                fileOut.close();
                System.out.println("Serialized data is saved in bank.ser");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        User found = b.getUserByAccountId(900);
        if (found != null) {
            // found.addBankAccount("hello", 1000);
            // try {
            // FileOutputStream fileOut = new FileOutputStream("bank.ser");
            // ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // out.writeObject(b);
            // out.close();
            // fileOut.close();
            // System.out.println("Serialized data is saved in bank.ser");
            // } catch (Exception e1) {
            // e1.printStackTrace();
            // }
            found.getAllBankAccounts();
        } else {
            System.out.println("User not found");
        }
    }
}
