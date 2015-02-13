package shoppingcart;

/**
 *
 * @author german
 */
class Item {
    
    private int itemId;
    private String itemName;
    private double price;

    //Constructor
    public Item(int itemId, String itemName, double price) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;

    }

    //Getters & Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
