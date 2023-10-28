package item;

public class Item {

    private int id;
    private String fullname;
    private String status;

    public Item() {
    }

    public Item(int id, String fullname, String status) {
        this.id = id;
        this.fullname = fullname;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return fullname + " (" + status + ")";
    }

}
