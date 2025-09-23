package atm_design.withdrawal_processor;

import atm_design.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawalProcessor {

    public TwoThousandWithdrawProcessor(CashWithdrawalProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {
        int required = remainingAmount / 2000;
        int balance = remainingAmount % 2000;

        if(required <= atm.getNoOfTwoThousandNotes()) {
            atm.deductTwoThousandNotes(required);
        } else {
            int temp = atm.getNoOfTwoThousandNotes();
            atm.deductTwoThousandNotes(temp);
            balance += (required - temp) * 2000;
        }

        if(balance != 0) super.withdraw(atm, balance);
    }

}
