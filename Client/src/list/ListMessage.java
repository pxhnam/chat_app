package list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Message;

public class ListMessage extends Object implements Serializable {

    List<Message> listMessage;

    public ListMessage() {
        this.listMessage = new ArrayList<>();
    }

    public void add(Message message) {
        listMessage.add(message);
    }

    public void remove(Message message) {
        listMessage.remove(message);
    }

    public void clear() {
        listMessage.clear();
    }

    public List<Message> printList() {
        return listMessage;
    }

    public int size() {
        return listMessage.size();
    }

    public void copy(List<Message> list) {
        list = listMessage;
    }
}
