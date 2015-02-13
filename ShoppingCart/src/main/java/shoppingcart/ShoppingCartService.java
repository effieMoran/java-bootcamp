package shoppingcart;

import org.springframework.stereotype.Service;

/**
 *
 * @author german
 */
@Service
public interface ShoppingCartService {
    
    public String sayHi();
    
    public String addItem(Item item);

    public String removeItem(int pos);

    public String getTotal();

    public String printDetail();
    
    

}
