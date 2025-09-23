package atm_design.withdrawal_processor;

import atm_design.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawalProcessor {

    public OneHundredWithdrawProcessor(CashWithdrawalProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int required = remainingAmount / 100;
        int balance = remainingAmount % 100;

        if(required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        } else {
            int temp = atm.getNoOfOneHundredNotes();
            atm.deductOneHundredNotes(temp);
            balance += (required - temp) * 100;
        }

        if(balance != 0) super.withdraw(atm, balance);
    }

}
