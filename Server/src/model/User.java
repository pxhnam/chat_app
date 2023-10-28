package model;

import java.io.Serializable;

public class User extends Object implements Serializable {

    private int id;
    private String fullname;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}
