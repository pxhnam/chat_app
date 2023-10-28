package model;

import java.io.Serializable;

public class Response extends Object implements Serializable {

    private boolean bool;
    private String message;

    public Response(boolean bool, String message) {
        this.bool = bool;
        this.message = message;
    }

    public Response() {
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
