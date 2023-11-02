package model;

import java.io.Serializable;

public class Lock extends Object implements Serializable {

    private int id;

    public Lock() {
    }

    public Lock(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
