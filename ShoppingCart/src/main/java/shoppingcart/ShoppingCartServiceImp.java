/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcart;

import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author german
 */

public class ShoppingCartServiceImp implements ShoppingCartService {
    
    private Cart cart;
    private final AtomicInteger counter ;
    
    
    protected ShoppingCartServiceImp(){
        cart = new Cart();
        counter = new AtomicInteger();
    }
    
    @Override
    public String sayHi() {
        return "Hello thanks for Buying and have a good one ";
    }
    
    
    @Override
    public String addItem(Item item) {
     
        cart.add(item);
        
        return "Item " + item.getItemId() + " - " + item.getItemName()
                + "\t$" + item.getPrice() + " added";
        
    }

    @Override
    public String removeItem(int pos) {

        String name = cart.getListOfItems().get(pos).getItemName();
        double price = cart.getListOfItems().get(pos).getPrice();

        cart.remove(pos);

        return "Item " + name + "\t$" + price + " removed";
    }

    @Override
    public String getTotal() {
        return "total:$"+String.valueOf(cart.getTotal());
    }

    @Override
    public String printDetail() {
        return cart.printDetail();
    }

    

    
}
