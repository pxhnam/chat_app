package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BroadCast extends Object implements Serializable {

    private String message;
    private Timestamp createdAt;

    public BroadCast() {
    }

    public BroadCast(String message) {
        this.message = message;
    }

    public BroadCast(String message, Timestamp createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
