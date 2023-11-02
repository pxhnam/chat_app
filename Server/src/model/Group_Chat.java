package model;

import java.io.Serializable;

public class Group_Chat extends Object implements Serializable {

    private int group;
    private String title;
    private String code;
    private int sender;

    public Group_Chat(int group, String title, String code, int sender) {
        this.group = group;
        this.title = title;
        this.code = code;
        this.sender = sender;
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

}
