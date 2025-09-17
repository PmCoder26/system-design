package state_design_pattern.vending_machine_design;


import lombok.Data;

@Data
public class Item {

    private ItemType itemType;
    private int price;

}
