package vanhack.Q1;

import java.util.ArrayList;

public class SushiOrder {
    private int seatId;
    private ArrayList<String> menuItemIds;

    public SushiOrder(int seatId, ArrayList<String> menuItemIds) {
        this.seatId = seatId;
        this.menuItemIds = menuItemIds;
    }

    public int getSeatId() {
        return seatId;
    }

    public ArrayList<String> getMenuItemIds() {
        return menuItemIds;
    }

    @Override
    public String toString() {
        return "SushiOrder{" +
                "seatId=" + seatId +
                ", menuItemIds=" + menuItemIds +
                '}';
    }
}
