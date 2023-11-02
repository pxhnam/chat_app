package list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Group;

public class ListGroup extends Object implements Serializable {

    List<Group> groups;

    public ListGroup() {
        groups = new ArrayList<>();
    }

    public void add(Group gr) {
        groups.add(gr);
    }

    public void remove(Group gr) {
        groups.remove(gr);
    }

    public void clear() {
        groups.clear();
    }

    public List<Group> print() {
        return groups;
    }

    public int size() {
        return groups.size();
    }
}
