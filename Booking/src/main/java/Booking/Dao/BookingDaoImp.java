package Booking.Dao;

import Booking.HibernateUtil;
import Booking.Pojos.Client;
import Booking.Pojos.Meetting;
import Booking.Pojos.Room;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

/**
 *
 * @author german
 */
@Component
public class BookingDaoImp implements BookingDao {

    //Date formatter use to parse the given  timestamp 
    java.text.SimpleDateFormat sdf
            = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public List getClients() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        String query = "FROM Client v";
        List<Client> resultSet = session.createQuery(query).list();
        session.close();
        return resultSet;
    }

    @Override
    public String addClient(String name, String lastName) {
        Client client = new Client(name, lastName);
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(client);
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Not Added" + e.toString());
        }

        return client.getName() + ","
                + client.getLastname() + " Added";
    }

    @Override
    public Client getClient(int idClient) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            Client client = (Client) session.get(Client.class, idClient);
            tx.commit();
            session.close();
            return client;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return new Client();
    }

    @Override
    public String destroyClient(int idClient) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            Client client = (Client) session.get(Client.class, idClient);
            session.delete(client);
            tx.commit();
            session.close();
            return client.getIdclient().toString() + "\n"
                    + client.getLastname() + "\n"
                    + client.getName() + " Deleted";
        } catch (HibernateException e) {
            return e.toString();
        }
    }

    @Override
    public List getRooms() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        String query = "FROM Room v";
        List listOfRoom = session.createQuery(query).list();
        session.close();
        return listOfRoom;
    }

    @Override
    public String addRoom(int floor, int capacity) {
        Room room = new Room(floor, capacity);

        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(room);
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("Not Added" + e.toString());
        }
        return "Floor: " + room.getFloor() + ","
                + "<br>Capacity:" + room.getCapacity() + " Added";

    }

    @Override
    public Room getRoom(int roomNum) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            Room room = (Room) session.get(Room.class, roomNum);
            tx.commit();
            session.close();
            return room;
        } catch (HibernateException e) {
            System.out.println(e.toString());
        }

        return new Room();
    }

    @Override
    public String destroyRoom(int roomNum) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            Room room = (Room) session.get(Room.class, roomNum);

            session.delete(room);

            tx.commit();

            session.close();

            return "RoomId: " + room.getRoomnum() + "\n Floor:" + room.getFloor()
                    + " Deleted";

        } catch (HibernateException e) {

            return e.toString();
        }
    }

    @Override
    public String addMeetting(int idClient, int roomNum, String startDate,
            String sTime, String finishDate, String fTime) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;

        String sartMeetting = startDate + " " + sTime;
        String finishMeetting = finishDate + " " + fTime;
        String response = "NOT ADDED";

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            Client client = (Client) session.get(Client.class, idClient);
            Room room = (Room) session.get(Room.class, roomNum);

            Date start = sdf.parse(sartMeetting);
            Date finish = sdf.parse(finishMeetting);

            if (start.after(finish)) {

                response = response + " Start date and time must to be, "
                        + "before finish date and time";

            } else {

                Meetting meetting = new Meetting(client, room, start, finish);

                session.save(meetting);

                session.getTransaction().commit();
                session.close();

                return client.getLastname() + "\n"
                        + client.getName() + " Added to " + room.getRoomnum();

            }

        } catch (Exception e) {

            System.out.println(e.toString());
        }

        return "<h1>" + response + "</h1>";
    }

    @Override
    public List getClientsInRoom(int roomNum) {
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;

        List meettings = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            String query = "SELECT v.client FROM Meetting v "
                    + "WHERE v.room.roomnum=" + roomNum;

            meettings = session.createQuery(query).list();

            session.close();
            return meettings;

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return meettings;
    }

    @Override
    public String cancelMeetting(int roomNum) {
        String response = "ROOM NOT FOUND";

        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            String query = "update meetting set status = false "
                    + "where roomnum =" + roomNum;

            session.createQuery(query);

            tx.commit();
            session.close();

            return "Metting in Room:" + roomNum + " Canceled";

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return "<h1>" + response + "</h1>";
    }

    @Override
    public String changeMeettingDate(int roomNum, String startDate, String sTime,
            String finishDate, String fTime) {

        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;

        String sartMeetting = startDate + " " + sTime;
        String finishMeetting = finishDate + " " + fTime;
        String response = "NOT UPDATED";

        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();

            Date start = sdf.parse(sartMeetting);
            Date finish = sdf.parse(finishMeetting);

            if (start.after(finish)) {

                response = response + " Start date and time must to be, "
                        + "before finish date and time";

            } else {

                String q = "UPDATE TABLE Meetting v SET v.startmeeting= :start"
                        + ", v.finishmeeting = :finish WHERE v.roomNum="+roomNum;

                Query query = session.createQuery(q);

                query.setParameter("start", start);
                query.setParameter("finish", finish);

                query.executeUpdate();

                session.close();

                return "The dates on Meetting in room" + roomNum +"\n"+
                        " has Changed " + start.toString()+"-"+
                        finish.toString();

            }
        } catch (Exception e) {

            System.out.println(e.toString());
        }

        return "<h1>" + response + "</h1>";

    }
    
        
}
