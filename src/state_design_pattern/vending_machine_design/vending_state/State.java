package state_design_pattern.vending_machine_design.vending_state;

import state_design_pattern.vending_machine_design.Coin;
import state_design_pattern.vending_machine_design.Item;
import state_design_pattern.vending_machine_design.VendingMachine;

import java.util.List;

public interface State {

    void clickOnInsertButton(VendingMachine vendingMachine) throws Exception;

    void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;

    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;

    void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    int getChange(int returnChangeMoney) throws Exception;

    Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;

    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;

}
