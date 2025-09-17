package state_design_pattern.vending_machine_design;

import lombok.Data;

@Data
public class Inventory {

    private ItemShelf[] inventory;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        initializeInventory();
    }

    private void initializeInventory() {
        int startCode = 101;
        for(int x = 0; x < inventory.length; x++) {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setCode(startCode++);
            itemShelf.setSoldOut(true);
            inventory[x] = itemShelf;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCode() == codeNumber) {
                if(itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else throw new Exception("Item already present, you can't add item here.");
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCode() == codeNumber) {
                if(itemShelf.isSoldOut()) throw new Exception("Item already sold you.");
                else return itemShelf.getItem();
            }
        }
        throw new Exception("Invalid Code.");
    }

    public void updateSoldOutItem(int codeNumber) {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

}
