package state_design_pattern.vending_machine_design.vending_state.impl;

import state_design_pattern.vending_machine_design.Coin;
import state_design_pattern.vending_machine_design.Item;
import state_design_pattern.vending_machine_design.VendingMachine;
import state_design_pattern.vending_machine_design.vending_state.State;

import java.util.ArrayList;
import java.util.List;

public class DispenseState implements State {

    public DispenseState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(vendingMachine, codeNumber);
        vendingMachine.setCoins(new ArrayList<>());
    }

    public void clickOnInsertButton(VendingMachine machine) throws Exception{
        throw new Exception("insert coin button can not clicked on Dispense state");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("product selection buttion can not be clicked in Dispense state");
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception{
        throw new Exception("coin can not be inserted in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception{
        throw new Exception("product can not be chosen in Dispense state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("change can not returned in Dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed.");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("refund can not be happen in Dispense state");
    }
}
