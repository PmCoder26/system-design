package atm_design;

import atm_design.atm_state.ATMState;
import atm_design.atm_state.HasCardState;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card inserted successfully");
        atm.setAtmState(new HasCardState());
    }

}
