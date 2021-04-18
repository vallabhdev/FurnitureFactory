package vanhack.Q1;

import java.util.Objects;

public class SushiItem {
    private int seatId;
    private String menuItemId;

    public SushiItem(int seatId, String menuItemId) {
        this.seatId = seatId;
        this.menuItemId = menuItemId;
    }

    public int getSeatId() {
        return seatId;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    @Override
    public String toString() {
        return "SushiItem{" +
                "seatId=" + seatId +
                ", menuItemId='" + menuItemId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SushiItem sushiItem = (SushiItem) o;
        return seatId == sushiItem.seatId && Objects.equals(menuItemId, sushiItem.menuItemId);
    }
}
