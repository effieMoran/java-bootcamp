package UserService;

import Model.Photo;
import Model.User;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Component;

/**
 *
 * @author german
 */
@Component
public class UserDaoImp implements UserDao {

    private final ArrayList<User> listOfUsers;
    private AtomicInteger photoCounter = new AtomicInteger();
    private AtomicInteger friendCounter = new AtomicInteger();

    public UserDaoImp() {
        listOfUsers = new ArrayList<>();
    }

    @Override

    public ArrayList<User> getAllUsers() {

        return this.listOfUsers;

    }

    @Override
    public void updateUser(int id, String name) {
        try {
           
            
            listOfUsers.get(searchUser(id)).setName(name);
            
            System.out.println("User\t" + id + "\thas been Updated");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void deleteUser(int id) {
        try {

            listOfUsers.remove(searchUser(id));
                      
            System.out.println("User\t" + id + "\thas been Deleted");
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void addUser(User user) {
        listOfUsers.add(user);
        System.out.println("User\t" + user.getUserId() + "\thas been Added");
    }

    @Override
    public void likeToUserPhoto(int id, int idPhoto) {
        try {
            
            int posPhoto = listOfUsers.get(searchUser(id)).searchPhoto(idPhoto);
            
            listOfUsers.get(searchUser(id)).getListOfUserPhotos().get(posPhoto).addLike();

            System.out.println("the Picture:"
                    + listOfUsers.get(searchUser(id)).getListOfUserPhotos().get(posPhoto).getPhotoUri()
                    + " has " + listOfUsers.get(searchUser(id)).getListOfUserPhotos().get(posPhoto).getLikes()
                    +" like");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void addPhoto(int id, String uri) {
        
        Photo photo = new Photo(photoCounter.incrementAndGet(),uri);
        
        listOfUsers.get(searchUser(id)).addPhoto(photo);
        
        System.out.println("Photo\t" + photo.getPhotoUri()+ "\thas been Added");
    }

    @Override
    public void addFriend(int idUser,int idFriend) {
        
        
        listOfUsers.get(searchUser(idUser)).addFriend(idFriend);
        
        
        listOfUsers.get(searchUser(idFriend)).addFriend(idUser);
        
        System.out.println("Now " +listOfUsers.get(searchUser(idFriend)).getName()+
                " and "+listOfUsers.get(searchUser(idUser)).getName() +" are Friends");
    }
    
    public int searchUser(int id){
        int i = 0;
        int position = -1;
        for(User user : listOfUsers){
            
            if(user.getUserId() == id){
             position = i;  
            }
            
            i++;
        }
        
        return position;
    }
    
    
    
    

}
