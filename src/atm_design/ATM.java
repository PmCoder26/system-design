package atm_design;

import atm_design.atm_state.ATMState;
import lombok.Data;

@Data
public class ATM {

    private ATMState atmState;

    private int atmBalance;
    private int noOfTwoThousandNotes;
    private int noOfFiveHundredNotes;
    private int noOfOneHundredNotes;

    public void deductATMBalance(int amount) {
        atmBalance -= amount;
    }

    public void deductTwoThousandNotes(int number) {
        noOfTwoThousandNotes -= number;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes -= number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes -= number;
    }

    public void printATMStatus() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("2000 Notes: " + noOfTwoThousandNotes);
        System.out.println("500 Notes: " + noOfFiveHundredNotes);
        System.out.println("100 Notes: " + noOfOneHundredNotes);
    }

}
