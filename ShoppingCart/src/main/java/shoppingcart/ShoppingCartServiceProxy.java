package shoppingcart;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author german
 */
@Component
public class ShoppingCartServiceProxy implements ShoppingCartService {

    @Autowired    
    private ShoppingCartService shoppingCart;
    
    public ShoppingCartServiceProxy(ShoppingCartService shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    public ShoppingCartServiceProxy(){
            
    }
    
    @Override
    public String sayHi() {
        return shoppingCart.sayHi();
    }


    @Override
    public String addItem(Item item) {
       
       return  shoppingCart.addItem(item);
        
    }


    @Override
    public String removeItem(int pos) {

        return shoppingCart.removeItem(pos);
    }


    @Override
    public String getTotal() {
        return shoppingCart.getTotal();
    }


    @Override
    public String printDetail() {
        return shoppingCart.printDetail();
    }
    


}
