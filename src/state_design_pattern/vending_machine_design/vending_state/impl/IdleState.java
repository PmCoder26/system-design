package state_design_pattern.vending_machine_design.vending_state.impl;

import state_design_pattern.vending_machine_design.Coin;
import state_design_pattern.vending_machine_design.Item;
import state_design_pattern.vending_machine_design.VendingMachine;
import state_design_pattern.vending_machine_design.vending_state.State;

import java.util.Collections;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Currently Vending Machine is in IdleState");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Currently Vending Machine is in IdleState");
        vendingMachine.setCoins(Collections.emptyList());
    }

    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("first you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("you can't insert coin in idle state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("you can't choose product in idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("you can't get the change in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("you can't dispense product in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you can't refund full money in idle state");
    }
}
