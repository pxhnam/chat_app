package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BroadCast extends Object implements Serializable {

    private String message;
    private Timestamp sentAt;

    public BroadCast() {
    }

    public BroadCast(String message) {
        this.message = message;
    }

    public BroadCast(String message, Timestamp sentAt) {
        this.message = message;
        this.sentAt = sentAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getSentAt() {
        return sentAt;
    }

    public void setSentAt(Timestamp sentAt) {
        this.sentAt = sentAt;
    }

}
