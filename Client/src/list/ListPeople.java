package list;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.People;

public class ListPeople extends Object implements Serializable {

    List<People> listPeople;

    public ListPeople() {
        listPeople = new ArrayList<>();
    }

    public void add(People people) {
        listPeople.add(people);
    }

    public void remove(People people) {
        listPeople.remove(people);
    }

    public void clear() {
        listPeople.clear();
    }

    public List<People> printList() {
        return listPeople;
    }

    public int size() {
        return listPeople.size();
    }

    public void copy(List<People> list) {
        list = listPeople;
    }
}
