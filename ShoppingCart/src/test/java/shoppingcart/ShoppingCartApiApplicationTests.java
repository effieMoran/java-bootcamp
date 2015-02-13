package shoppingcart;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ShoppingCartApiApplication.class)
@WebAppConfiguration
public class ShoppingCartApiApplicationTests {

    @Test
    public void testAddItemLocal() {
        
        ShoppingCartService cartservice = ServiceFactory.getLocalService();
        
        Item item1 = new Item(1,"short",9.56);
        
                
        String expected = "Item 1 - short\t$9.56 added";
        
        assertEquals(expected,cartservice.addItem(item1));
        
        
    }
    
   
    @Test
    public void testRemoveItemLocal() {
        
        ShoppingCartService cartservice = ServiceFactory.getLocalService();
        
        Item item1 = new Item(1,"short",9.56);
        cartservice.addItem(item1);
              
        String expected = "Item short\t$9.56 removed";
        
        assertEquals(expected,cartservice.removeItem(0));
        
        
    }
    
    @Test
    public void testGetTotalLocal() {
        
        ShoppingCartService cartservice = ServiceFactory.getLocalService();
        
        Item item1 = new Item(1,"short",10.91);
        Item item2 = new Item(2,"blanket",0.08);
        cartservice.addItem(item1);
        cartservice.addItem(item2);
        
        String expected = "total:$10.99";
        
        assertEquals(expected,cartservice.getTotal());
        
        
    }
    
    @Test
    public void testPrintDetailLocal() {
        
        ShoppingCartService cartservice = ServiceFactory.getLocalService();
        
        Item item1 = new Item(1,"short",10.91);
        Item item2 = new Item(2,"blanket",0.08);
        cartservice.addItem(item1);
        cartservice.addItem(item2);
        
        
        System.out.println(cartservice.printDetail());
        String expected = "1\tshort\t$10.91\n"
                        + "2\tblanket\t$0.08\n"
                        + "\n\nTotal:$10.99"   ;
        
        assertEquals(expected,cartservice.printDetail());
        
        
    }
    
      @Test
    public void testAddItemRemote() {
        
        ShoppingCartService cartservice = ServiceFactory.getRemoteServiceUsingWebService();
        
        Item item1 = new Item(1,"short",9.56);
        
                
        String expected = "Item 1 - short\t$9.56 added";
        
        assertEquals(expected,cartservice.addItem(item1));
        
        
    }
    
   
    @Test
    public void testRemoveItemRemote() {
        
        ShoppingCartService cartservice = ServiceFactory.getRemoteServiceUsingWebService();
        
        Item item1 = new Item(1,"short",9.56);
        cartservice.addItem(item1);
              
        String expected = "Item short\t$9.56 removed";
        
        assertEquals(expected,cartservice.removeItem(0));
        
        
    }
    
    @Test
    public void testGetTotalRemote() {
        
        ShoppingCartService cartservice = ServiceFactory.getRemoteServiceUsingWebService();
        
        Item item1 = new Item(1,"short",10.91);
        Item item2 = new Item(2,"blanket",0.08);
        cartservice.addItem(item1);
        cartservice.addItem(item2);
        
        String expected = "total:$10.99";
        
        assertEquals(expected,cartservice.getTotal());
        
        
    }
    
    @Test
    public void testPrintDetailRemote() {
        
        ShoppingCartService cartservice = ServiceFactory.getRemoteServiceUsingWebService();
        
        Item item1 = new Item(1,"short",10.91);
        Item item2 = new Item(2,"blanket",0.08);
        cartservice.addItem(item1);
        cartservice.addItem(item2);
        
        
        System.out.println(cartservice.printDetail());
        String expected = "1\tshort\t$10.91\n"
                        + "2\tblanket\t$0.08\n"
                        + "\n\nTotal:$10.99"   ;
        
        assertEquals(expected,cartservice.printDetail());
        
        
    }
    
    

}
