package model;

import java.io.Serializable;

public class CurrentUser extends Object implements Serializable {

    private static int id;
    private static String fullname;

    public CurrentUser() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        CurrentUser.id = id;
    }

    public static String getFullname() {
        return fullname;
    }

    public static void setFullname(String fullname) {
        CurrentUser.fullname = fullname;
    }

}
