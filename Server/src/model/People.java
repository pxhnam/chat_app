package model;

import java.io.Serializable;

public class People extends Object implements Serializable {

    private int id;
    private String username;
    private String fullname;
    private boolean status;

    public People() {
    }

    public People(int id, String username, String fullname, boolean status) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
