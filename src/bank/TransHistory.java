package src.bank;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TransHistory implements Serializable {
    String type;
    double amount;
    LocalDateTime t;

    public TransHistory(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.t = LocalDateTime.now();
    }

    public void show() {
        System.out.println("Type: " + type + " Amount: " + amount + " Time: " + t);
    }

}
