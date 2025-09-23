package atm_design.atm_state;

import atm_design.ATM;
import atm_design.Card;
import atm_design.IdleState;

public class HasCardState extends ATMState {

    public HasCardState() {
        System.out.println("Inside the HasCardState");
        System.out.println("Enter your pin number");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {
        if(card.isCorrectPINEntered(pin)) {
            System.out.println("Authentication Successful");
            atm.setAtmState(new SelectOperationState());
        }
        else {
            System.out.println("Invalid pin entered");
            exit(atm);
        }
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
