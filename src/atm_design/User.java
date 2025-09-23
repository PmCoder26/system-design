package atm_design;

import lombok.Data;

@Data
public class User {

    private Card card;
    private BankAccount bankAccount;

}
