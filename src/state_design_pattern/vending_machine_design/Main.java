package state_design_pattern.vending_machine_design;

import state_design_pattern.vending_machine_design.vending_state.State;

public class Main {

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i<3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            } else if(i<5) {
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if(i<7) {
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            } else if(i<10) {
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (ItemShelf slot : slots) {
            System.out.println(
                    "CodeNumber: " + slot.getCode() +
                    " Item: " + slot.getItem().getItemType().name() +
                    " Price: " + slot.getItem().getPrice() +
                    " isAvailable: " + !slot.isSoldOut()
            );
        }
    }



    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try {

            System.out.println("|");
            System.out.println("filling up the inventory...");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            State vendingState = vendingMachine.getVendingState();
            vendingState.clickOnInsertButton(vendingMachine);

            // inserting coins.
            vendingState = vendingMachine.getVendingState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);

            System.out.println("|");
            System.out.println("clicking on the product selection button...");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            // product selection button.
            vendingState = vendingMachine.getVendingState();
            vendingState.chooseProduct(vendingMachine, 102);

            // displaying the inventory.
            displayInventory(vendingMachine);

        } catch (Exception e) {
            displayInventory(vendingMachine);
        }

    }


}
