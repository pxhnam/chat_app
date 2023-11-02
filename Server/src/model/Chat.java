package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Chat extends Object implements Serializable {

    private int group;
    private String title;
    private String code;
    private int sender;
    private String name;
    private String message;
    private Timestamp sentAt;

    public Chat() {
    }

    public Chat(int group, int sender, String name, String message) {
        this.group = group;
        this.sender = sender;
        this.name = name;
        this.message = message;
    }

    public Chat(int sender, String name, String message, Timestamp sentAt) {
        this.sender = sender;
        this.name = name;
        this.message = message;
        this.sentAt = sentAt;
    }

    public Chat(int group, String title, String code, int sender, String name, String message) {
        this.group = group;
        this.title = title;
        this.code = code;
        this.sender = sender;
        this.name = name;
        this.message = message;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
