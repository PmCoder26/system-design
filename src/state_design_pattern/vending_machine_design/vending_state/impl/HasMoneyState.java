package state_design_pattern.vending_machine_design.vending_state.impl;

import state_design_pattern.vending_machine_design.Coin;
import state_design_pattern.vending_machine_design.Item;
import state_design_pattern.vending_machine_design.VendingMachine;
import state_design_pattern.vending_machine_design.vending_state.State;

import java.util.List;

public class HasMoneyState implements State  {

    public HasMoneyState() {
        System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        vendingMachine.getCoins().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("you can't choose product in HasMoneyState.");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can't get the change in HasMoneyState.");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("you can't dispense product selection button in HasMoneyState.");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingState(new IdleState(vendingMachine));
        return vendingMachine.getCoins();
    }
}
