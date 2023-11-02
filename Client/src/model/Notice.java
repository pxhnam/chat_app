package model;

import java.io.Serializable;

public class Notice extends Object implements Serializable {

    private static int ID;
    private static String type;

    public Notice() {
    }

    public synchronized static void set(int ID, String type) {
        Notice.ID = ID;
        Notice.type = type;
    }

    public synchronized static int getID() {
        return ID;
    }

    public synchronized static void setID(int ID) {
        Notice.ID = ID;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        Notice.type = type;
    }

}
