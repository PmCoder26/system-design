package state_design_pattern.vending_machine_design.vending_state.impl;

import state_design_pattern.vending_machine_design.Coin;
import state_design_pattern.vending_machine_design.Item;
import state_design_pattern.vending_machine_design.VendingMachine;
import state_design_pattern.vending_machine_design.vending_state.State;

import java.util.ArrayList;
import java.util.List;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently Vending Machine is in SelectionState.");
    }

    @Override
    public void clickOnInsertButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("you can not click on insert coin button in selection state.");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("you can not insert coin in Selection state.");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        // get the item by the code number.
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        // check the total coins paid by the user.
        int paidByUser = 0;
        for(Coin coin: vendingMachine.getCoins()) {
            paidByUser += coin.value;
        }
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Selected Product price: " + item.getPrice() + ", You paid: " + paidByUser);
            refundFullMoney(vendingMachine);
            vendingMachine.setVendingState(new HasMoneyState());
            throw new Exception("Insufficient Money!");
        }
        else if(paidByUser > item.getPrice()) {
            getChange(paidByUser - item.getPrice());
            vendingMachine.setVendingState(new DispenseState(vendingMachine, codeNumber));
        }
        else {
            vendingMachine.setVendingState(new DispenseState(vendingMachine, codeNumber));
        }
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned full amount of money in the dispense tray.");
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("you can't dispense product in selection state.");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        List<Coin> coins = vendingMachine.getCoins();
        vendingMachine.setCoins(new ArrayList<>());
        return coins;
    }
}
