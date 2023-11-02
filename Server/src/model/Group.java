package model;

import java.io.Serializable;

public class Group extends Object implements Serializable {

    private int ID;
    private String code;
    private int user;
    private String name;

    public Group() {
    }

    public Group(int user) {
        this.user = user;
    }

    public Group(int ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
