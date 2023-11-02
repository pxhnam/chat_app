package list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Chat;

public class ListChat extends Object implements Serializable {

    List<Chat> chats;
    private int ID;
    private String title;
    private String code;

    public ListChat() {
        chats = new ArrayList<>();
    }

    public void add(Chat chat) {
        chats.add(chat);
    }

    public void remove(Chat chat) {
        chats.remove(chat);
    }

    public void clear() {
        chats.clear();
    }

    public List<Chat> print() {
        return chats;
    }

    public int size() {
        return chats.size();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

}
