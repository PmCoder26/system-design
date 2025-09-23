package atm_design.atm_state;

import atm_design.ATM;
import atm_design.Card;
import atm_design.IdleState;
import atm_design.TransactionType;

public class SelectOperationState extends ATMState {

    public SelectOperationState() {
        System.out.println("Inside the SelectOperationState");
        showOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case BALANCE_CHECK -> atm.setAtmState(new CheckBalanceState());
            case CASH_WITHDRAWAL -> atm.setAtmState(new CashWithdrawalState());
            default -> {
                System.out.println("Invalid option");
                exit(atm);
            }
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

    public void showOperations() {
        System.out.println("Please select an operation");
        TransactionType.showAllTransactionTypes();
    }

}
