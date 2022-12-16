package src.bank;

import java.io.Serializable;
import java.util.ArrayList;
import src.users.*;

public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    ArrayList<User> people = new ArrayList<User>();

    public void addUser(User u) {
        people.add(u);
    }

    // public void getAllUsers() {
    // for (User u : people) {
    // System.out.println(u.accountNumber + " " + u.firstName + " " + u.lastName);
    // }
    // }

    public String[][] getAllUsers() {
        String[][] data = new String[people.size()][5];
        for (int i = 0; i < people.size(); i++) {
            data[i][0] = Integer.toString(people.get(i).accountNumber);
            data[i][1] = people.get(i).firstName;
            data[i][2] = people.get(i).lastName;
            data[i][3] = people.get(i).email;
            data[i][4] = Integer.toString(people.get(i).phoneNumber);
        }
        return data;
    }

    public void deleteUser(int accountNumber) {
        for (User u : people) {
            if (u.accountNumber == accountNumber) {
                if (u.accountNumber == 2003) {
                    System.out.println("Cannot delete admin");
                } else {
                    people.remove(u);
                    System.out.println("User deleted");
                }
                break;
            }
        }
    }

    public User getUserByAccountId(int id) {
        for (User i : people) {
            if (i.accountNumber == id) {
                return i;
            }
        }
        return null;
    }

}
