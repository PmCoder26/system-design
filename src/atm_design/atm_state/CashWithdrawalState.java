package atm_design.atm_state;

import atm_design.ATM;
import atm_design.Card;
import atm_design.IdleState;
import atm_design.withdrawal_processor.CashWithdrawalProcessor;
import atm_design.withdrawal_processor.FiveHundredWithdrawProcessor;
import atm_design.withdrawal_processor.OneHundredWithdrawProcessor;
import atm_design.withdrawal_processor.TwoThousandWithdrawProcessor;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Inside CashWithdrawalState");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
        if(atm.getAtmBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in the ATM");
            exit(atm);
        } else if(card.getBankBalance() < withdrawAmount) {
            System.out.println("Insufficient fund in your bank account");
            exit(atm);
        } else {
            card.deductBankBalance(withdrawAmount);
            atm.deductATMBalance(withdrawAmount);

            CashWithdrawalProcessor processor = new TwoThousandWithdrawProcessor(
                    new FiveHundredWithdrawProcessor(
                            new OneHundredWithdrawProcessor(null)
                    )
            );
            processor.withdraw(atm, withdrawAmount);

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
