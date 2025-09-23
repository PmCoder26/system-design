package atm_design;

import lombok.Data;

@Data
public class Card {

    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private int pin_number = 1221;
    private BankAccount bankAccount;

    public boolean isCorrectPINEntered(int pin) {
        return pin_number == pin;
    }

    public int getBankBalance() {
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawBalance(amount);
    }

}
