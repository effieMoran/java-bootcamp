package Model;

/**
 *
 * @author german
 */
public class Photo {
    private int idPhoto;
    private String photoUri;
    private int likes;
    
    //Constructor
    
    public Photo(int idPhoto,String photoUri){
        this.idPhoto = idPhoto;
        this.photoUri = photoUri;
    }
    
    //Getters & Setters
    public int getIdPhoto() {
        return idPhoto;
    }

    public String getPhotoUri() {
        return photoUri;
    }

    public int getLikes() {
        return likes;
    }

    public void setIdPhoto(int idPhoto) {
        this.idPhoto = idPhoto;
    }

    public void setPhotoUri(String photoUri) {
        this.photoUri = photoUri;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    //Methods
    
    public void addLike(){
        this.likes+=1;
    }
    
    public void removeLike(){
        this.likes-=1;
    }

}
