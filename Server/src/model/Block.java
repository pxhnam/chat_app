package model;

import java.io.Serializable;

public class Block extends Object implements Serializable {

    private int id;

    public Block() {
    }

    public Block(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
