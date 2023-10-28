package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message extends Object implements Serializable {

    private int to;
    private int from;
    private String msg;
    private Timestamp createdAt;

    public Message() {
    }

    public Message(String msg) {
        this.msg = msg;
    }

    public Message(String msg, Timestamp createdAt) {
        this.msg = msg;
        this.createdAt = createdAt;
    }

    public Message(int to, int from, String msg) {
        this.to = to;
        this.from = from;
        this.msg = msg;
    }

    public Message(int to, int from, String msg, Timestamp createdAt) {
        this.to = to;
        this.from = from;
        this.msg = msg;
        this.createdAt = createdAt;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
