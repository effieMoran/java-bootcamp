package Booking.Dao;

import Booking.Pojos.Client;
import Booking.Pojos.Room;
import java.util.List;

/**
 *
 * @author german
 */
public interface BookingDao {

    public List getClients();

    public String addClient(String name, String lastName);

    public Client getClient(int idClient);

    public String destroyClient(int idClient);

    public List getRooms();

    public String addRoom(int floor, int capacity);

    public Room getRoom(int roomNum);

    public String destroyRoom(int roomNum);

    public String addMeetting(int idClient, int roomNum, String startDate, String sTime,
            String finishDate, String fTime);

    public List getClientsInRoom(int roomNum);

    public String cancelMeetting(int roomNum);

    public String changeMeettingDate(int roomNum, String startDate, String sTime,
            String finishDate, String fTime);

}
