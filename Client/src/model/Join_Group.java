package model;

import java.io.Serializable;

public class Join_Group extends Object implements Serializable {

    private int ID;
    private int user;
    private String code;
    private String name;
    private boolean isJoin;
    private String response;

    public Join_Group() {
    }

    public Join_Group(String code, int user) {
        this.code = code;
        this.user = user;
    }

    public Join_Group(int ID, String name, String code, boolean isJoin) {
        this.ID = ID;
        this.name = name;
        this.code = code;
        this.isJoin = isJoin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public boolean isIsJoin() {
        return isJoin;
    }

    public void setIsJoin(boolean isJoin) {
        this.isJoin = isJoin;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
