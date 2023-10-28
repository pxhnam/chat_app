package model;

import java.io.Serializable;

public class Login extends Object implements Serializable {

    private int id;

    public Login() {
    }

    public Login(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
