package state_design_pattern.vending_machine_design;

import lombok.Data;
import state_design_pattern.vending_machine_design.vending_state.State;
import state_design_pattern.vending_machine_design.vending_state.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendingMachine {

    private State vendingState;
    private Inventory inventory;
    private List<Coin> coins;

    public VendingMachine() {
        vendingState = new IdleState();
        inventory = new Inventory(10);
        coins = new ArrayList<>();
    }

}
