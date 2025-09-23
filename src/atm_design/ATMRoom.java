package atm_design;

import atm_design.atm_state.ATMState;

public class ATMRoom {

    private ATM atm;
    private User user;

    public void initialize() {
        // create atm.
        atm = new ATM();
        atm.setAtmBalance(5000);
        atm.setAtmState(new IdleState());
        atm.setNoOfTwoThousandNotes(2);
        atm.setNoOfFiveHundredNotes(2);
        atm.setNoOfOneHundredNotes(10);

        // create user.
        this.user = createUser();
    }

    private User createUser() {
        User user = new User();
        user.setCard(createCard());
        user.setBankAccount(user.getCard().getBankAccount());
        return user;
    }

    private Card createCard() {
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private BankAccount createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(10000);
        return bankAccount;
    }

    public static void main(String[] args) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printATMStatus();
        System.out.println();
        ATMState state = atmRoom.atm.getAtmState();
        state.insertCard(atmRoom.atm, atmRoom.user.getCard());
        System.out.println();
        state = atmRoom.atm.getAtmState();
        state.authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 1221);
        System.out.println();
        state = atmRoom.atm.getAtmState();
        state.selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        System.out.println();
        state = atmRoom.atm.getAtmState();
        state.cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 3500);
        System.out.println();
        atmRoom.atm.printATMStatus();

    }

}
