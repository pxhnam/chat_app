package model;

import java.io.Serializable;

public class Create_Group extends Object implements Serializable {

    private int ID;
    private String code;
    private String name;
    private int founder;
    private String user;
    private boolean isSuccess;
    private String response;

    public Create_Group() {
    }

    public Create_Group(String name, int founder, String user) {
        this.name = name;
        this.founder = founder;
        this.user = user;
    }

    public Create_Group(int ID, String code, String name, boolean isSuccess) {
        this.ID = ID;
        this.code = code;
        this.name = name;
        this.isSuccess = isSuccess;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFounder() {
        return founder;
    }

    public void setFounder(int founder) {
        this.founder = founder;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
