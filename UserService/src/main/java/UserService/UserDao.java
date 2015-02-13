package UserService;

import Model.User;
import Model.Photo;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author german
 */


public interface UserDao {

    public ArrayList<User> getAllUsers();
    public void updateUser(int id, String name);
    public void deleteUser(int id);
    public void addUser(User user);
    public void addPhoto(int id,String uri);
    public void addFriend(int idUser,int idFriend);
    public void likeToUserPhoto(int id,int idPhoto);

    

}
