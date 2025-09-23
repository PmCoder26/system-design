package atm_design.atm_state;

import atm_design.ATM;
import atm_design.Card;
import atm_design.IdleState;

public class CheckBalanceState extends ATMState {

    public CheckBalanceState() {
        System.out.println("Inside CheckBalanceState");
    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is : "  + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happened");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }

}
