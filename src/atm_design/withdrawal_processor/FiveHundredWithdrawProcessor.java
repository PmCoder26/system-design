package atm_design.withdrawal_processor;

import atm_design.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawalProcessor {

    public FiveHundredWithdrawProcessor(CashWithdrawalProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int required = remainingAmount / 500;
        int balance = remainingAmount % 500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        } else {
            int temp = atm.getNoOfFiveHundredNotes();
            atm.deductFiveHundredNotes(temp);
            balance += (required - temp) * 500;
        }

        if(balance != 0) super.withdraw(atm, balance);
    }

}
