package model;

import java.io.Serializable;
import java.util.Date;

public class Information extends Object implements Serializable {

    private int id;
    private String fullname;
    private int gender;
    private Date dob;

    public Information() {
    }

    public Information(int id) {
        this.id = id;
    }

    public Information(String fullname, int gender, Date dob) {
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
