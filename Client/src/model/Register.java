package model;

import java.io.Serializable;
import java.util.Date;

public class Register extends Object implements Serializable {

    private int id;
    private String username;
    private String password;
    private String fullname;
    private int gender;
    private Date dob;

    public Register() {
    }

    public Register(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

    public Register(String username, String password, String fullname, int gender, Date dob) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.dob = dob;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
