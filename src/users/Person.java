package src.users;

import java.io.Serializable;

public class Person implements Serializable {
    public String firstName;
    public String lastName;
    public String email;
    public int phoneNumber;

    public Person(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
