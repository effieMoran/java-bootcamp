package Model;

import java.util.ArrayList;

/**
 *
 * @author german
 */
public class User {
    
   private  String name;
   private  int userId;
   
   private  String password;
   private  Photo profilePhotoUrl;
   private  ArrayList<Integer> listOfUserFriends = new ArrayList<>();;
   private  ArrayList<Photo> listOfUserPhotos = new ArrayList<>();
   
   
   //Contructor
   public User(int userId,String name,String password){
       
       this.userId=userId;
       this.name =name;
       this.password = password;
       
       
   }
   
   //Getters & Setters
   
    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Photo getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public ArrayList<Integer> getListOfUserFriends() {
        return listOfUserFriends;
    }

    public ArrayList<Photo> getListOfUserPhotos() {
        return listOfUserPhotos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePhotoUrl(Photo profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public void setListOfUserFriends(ArrayList<Integer> listOfUserFriends) {
        this.listOfUserFriends = listOfUserFriends;
    }

    public void setListOfUserPhotos(ArrayList<Photo> listOfUserPhotos) {
        this.listOfUserPhotos = listOfUserPhotos;
    }
    
    
    //Methods
    
   public void addPhoto(Photo pic){
       
       
       this.listOfUserPhotos.add(pic);
   }
   
   public void removePhoto(int pos){
       try{
       
           this.getListOfUserPhotos().remove(pos);
           
       }catch (Exception e){
           System.out.println(e.toString());
       }
   }
   
   public void addFriend(int idFriend){
       
       
       this.listOfUserFriends.add(idFriend);
   }
   
   
   public void removeFriend(int pos){
       try{
       
            this.listOfUserFriends.remove(pos);
           
       }catch (Exception e){
           System.out.println(e.toString());
       }
   }
   
   public int searchPhoto(int photoId){
        int i = 0;
        int position = -1;
        for(Photo photo : listOfUserPhotos){
            
            if(photo.getIdPhoto()== photoId){
             position = i;  
            }
            
            i++;
            System.out.println(i);
        }
        
        return position;
    }
    
    
   
   
   

}
