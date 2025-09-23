package atm_design.withdrawal_processor;

import atm_design.ATM;

public abstract class CashWithdrawalProcessor {

    CashWithdrawalProcessor nextProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount) {
        if(nextProcessor != null) {
            nextProcessor.withdraw(atm, remainingAmount);
        }
    }

}
