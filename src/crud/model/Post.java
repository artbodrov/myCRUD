package crud.model;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private int id;
    private String content;
    private String created;
    private String updated;
    private List<Label> labels = new ArrayList<>();


    public Post(){

    }
    public Post(Integer id,String content,String created,String updated){
        this.id=id;
        this.content=content;
        this.created=created;
        this.updated=updated;

    }

    public void addLabel(Label label) {
        labels.add(label);


    }

    public List<Label> getLabels() {


        return labels;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", labels=" + labels +
                '}';
    }
}
