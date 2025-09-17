package state_design_pattern.vending_machine_design;

import lombok.Data;

@Data
public class ItemShelf {

    private int code;
    private Item item;
    private boolean soldOut;

}
