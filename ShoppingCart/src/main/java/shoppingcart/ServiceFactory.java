package shoppingcart;

/**
 *
 * @author german
 */
public class ServiceFactory {
    
    
    private ServiceFactory(){
        
    }
    
    public static ShoppingCartService getLocalService(){
        return new ShoppingCartServiceImp();
    }
    
    
    public static ShoppingCartService getRemoteServiceUsingWebService(){
        return new ShoppingCartServiceProxy(new     ShoppingCartWebService());
        
    }

}
