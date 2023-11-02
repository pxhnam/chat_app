package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message extends Object implements Serializable {

    private int to;
    private int from;
    private String msg;
    private String nameSender;
    private Timestamp sentAt;

    public Message() {
    }

    public Message(String msg) {
        this.msg = msg;
    }

    public Message(String msg, Timestamp sentAt) {
        this.msg = msg;
        this.sentAt = sentAt;
    }

    public Message(int to, int from, String msg) {
        this.to = to;
        this.from = from;
        this.msg = msg;
    }

    public Message(int to, int from, String nameSender, String msg, Timestamp sentAt) {
        this.to = to;
        this.from = from;
        this.nameSender = nameSender;
        this.msg = msg;
        this.sentAt = sentAt;
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

    public String getNameSender() {
        return nameSender;
    }

    public void setNameSender(String nameSender) {
        this.nameSender = nameSender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Timestamp getSentAt() {
        return sentAt;
    }

    public void setSentAt(Timestamp sentAt) {
        this.sentAt = sentAt;
    }

}
