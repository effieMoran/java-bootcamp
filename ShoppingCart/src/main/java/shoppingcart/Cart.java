package shoppingcart;

import java.util.ArrayList;

/**
 *
 * @author german
 */
class Cart {

    
  
    private ArrayList<Item> listOfItems;
    private double total;
    

    public Cart() {
        listOfItems = new ArrayList<>();
    }

  
    
    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public double getTotal() {

        double totals = 0;

        for (Item item : this.getListOfItems()) {
            totals += item.getPrice();
        }

        this.setTotal(totals);

        return totals;
    }

    private void setTotal(double total) {
        this.total = total;
    }

    public void add(Item item) {
        
        this.listOfItems.add(item);
    }

    public void remove(int pos) {
        this.listOfItems.remove(pos);
    }

    public String printDetail() {

        String detail = "";

        for (Item item : listOfItems) {

            detail += item.getItemId() + "\t" + item.getItemName() + "\t$" 
                    + item.getPrice() + "\n";

        }
        detail += "\n\nTotal:$" + String.valueOf(this.getTotal());

        return detail;
    }

}
