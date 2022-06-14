package crud.model;

import java.io.*;

public class Label {
    private int id;
    private String name;

    public Label() {
    }
    public Label(Integer id, String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws IOException {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name=" + name;
    }

}
