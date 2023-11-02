package model;

import java.io.Serializable;

public class Block extends Object implements Serializable {

    private int blocker;
    private int blocked;

    public Block() {
    }

    public Block(int blocker, int blocked) {
        this.blocker = blocker;
        this.blocked = blocked;
    }

    public int getBlocker() {
        return blocker;
    }

    public void setBlocker(int blocker) {
        this.blocker = blocker;
    }

    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }
}
