package model;

import java.io.Serializable;

public class Add_Friend extends Object implements Serializable {

    private int me;
    private int idFr;
    private String name;
    private String email;
    private boolean status;
    private boolean isFriend;
    private String response;

    public Add_Friend() {
    }

    public Add_Friend(int me, String email) {
        this.me = me;
        this.email = email;
    }

    public Add_Friend(int idFr, String name, boolean status, boolean isFriend) {
        this.idFr = idFr;
        this.name = name;
        this.status = status;
        this.isFriend = isFriend;
    }

    public int getMe() {
        return me;
    }

    public void setMe(int me) {
        this.me = me;
    }

    public int getIdFr() {
        return idFr;
    }

    public void setIdFr(int idFr) {
        this.idFr = idFr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIsFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
