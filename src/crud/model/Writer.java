package crud.model;

import java.util.ArrayList;
import java.util.List;

public class Writer {

    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts = new ArrayList<>();

 public Writer() {

 }


  public Writer(Integer id, String firstName,String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public void addPost(Post post){
        posts.add(post);

    }
    public List<Post> getPosts(){
        return posts;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
   @Override
       public String toString() {
           return  "id=" + id +
                   ", firstName=" + firstName +
                   ", lastName=" + lastName ;


       }
}
