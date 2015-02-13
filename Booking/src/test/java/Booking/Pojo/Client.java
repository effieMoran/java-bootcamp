package Booking.Pojo;

import javax.persistence.Entity;

/**
 *
 * @author german
 */
@Entity
public class Client {
    
    private int idClient;
    private String name;
    private String lastName;
    
    public Client(String name, String lastName){
        this.name = name;
        this.lastName = name;
    }
    
    
    
    

}
