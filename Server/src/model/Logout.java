package model;

import java.io.Serializable;

public class Logout extends Object implements Serializable {

    private int id;
    private String username;

    public Logout() {
    }

    public Logout(int id) {
        this.id = id;
    }

    public Logout(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
