package Booking.Controllers;

import Booking.Dao.BookingDao;
import Booking.Pojos.Client;
import Booking.Pojos.Room;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author german
 */
@RestController
public class BookingController {

//Date formatter use to parse the given  timestamp 
    java.text.SimpleDateFormat sdf
            = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Resource
    BookingDao bookingDao;

    @RequestMapping("/")
    public String index() {
        return "Hello Server is Working!!! :)";
    }
    
    @RequestMapping("/client/all")
    public List<Client> getClients() {
        return bookingDao.getClients();
    }

    @RequestMapping("/client/new")
    public String addClient(@RequestParam(value = "name") String name,
            @RequestParam(value = "lastname") String lastName) {
        return bookingDao.addClient(name, lastName);
    }

    @RequestMapping("/client/by")
    public Client getClient(@RequestParam(value = "id") int idClient) {
        return bookingDao.getClient(idClient);
    }

    @RequestMapping("/client/destroy")
    public String destroyClient(@RequestParam(value = "id") int idClient) {
        return bookingDao.destroyClient(idClient);
    }

    @RequestMapping("/room/all")
    public List getRooms() {
        return bookingDao.getRooms();
    }

    @RequestMapping("/room/new")
    public String addRoom(@RequestParam(value = "floor") int floor,
            @RequestParam(value = "capacity") int capacity) {
        return bookingDao.addRoom(floor, capacity);
    }

    @RequestMapping("/room/by")
    public Room getRoom(@RequestParam(value = "id") int roomNum) {
        return bookingDao.getRoom(roomNum);
    }

    @RequestMapping("/room/destroy")
    public String destroyRoom(@RequestParam(value = "id") int roomNum) {
        return bookingDao.destroyRoom(roomNum);
    }

    @RequestMapping("/meetting/new")
    public String addMeetting(@RequestParam(value = "idClient") int idClient,
            @RequestParam(value = "roomnum") int roomNum,
            @RequestParam(value = "sDate") String startDate,
            @RequestParam(value = "sTime") String sTime,
            @RequestParam(value = "fDate") String finishDate,
            @RequestParam(value = "fTime") String fTime) {
        return bookingDao.addMeetting(idClient, roomNum, startDate, sTime,
                finishDate, fTime);
    }

    @RequestMapping("/meetting/clients/in/room")
    public List getClientsInRoom(@RequestParam(value = "id") int roomNum) {
        return bookingDao.getClientsInRoom(roomNum);
    }

    @RequestMapping("/meetting/cancel")
    public String cancelMeetting(@RequestParam(value = "roomnum") int roomNum) {
        return bookingDao.cancelMeetting(roomNum);
    }
    @RequestMapping("/meetting/date")
    public String changeMeettingDate(@RequestParam(value = "roomnum") int roomNum,
            @RequestParam(value = "sDate") String startDate,
            @RequestParam(value = "sTime") String sTime,
            @RequestParam(value = "fDate") String finishDate,
            @RequestParam(value = "fTime") String fTime){
       return bookingDao.changeMeettingDate(roomNum, startDate, sTime, finishDate
               , fTime);
    }

}
