package atm_design;

import lombok.Data;

@Data
public class BankAccount {

    private int balance;

    public void withdrawBalance(int amount) {
        balance -= amount;
    }

}
