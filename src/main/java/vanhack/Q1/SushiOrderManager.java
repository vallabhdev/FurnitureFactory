package vanhack.Q1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class SushiOrderManager {
    private int currentSeat;
    private int totalSeats;
    private boolean roundEnded = false;
    private ArrayList<Queue<SushiItem>> seats;
    private Queue<ArrayList<SushiOrder>> groupOrder = new LinkedList<>();

    public SushiOrderManager() {
        currentSeat = 0;
        totalSeats = 16;
        seats = new ArrayList<>();

        for (int i = 0; i < totalSeats; i++) {
            seats.add(new LinkedList<SushiItem>());
        }
    }

    public void addOrder(ArrayList<SushiOrder> request) {
        if (roundEnded || groupOrder.peek() == null) {
            groupOrder.offer(request);
        } else {
            groupOrder.peek().addAll(request);
        }
    }

    public SushiItem nextItem() {
        if (!hasAnyItemLeft(seats)) {
            ArrayList<SushiOrder> polledOrder = groupOrder.poll();
            if (polledOrder == null) {
                return null;
            } else {
                populateOrderAsPerSeat(polledOrder);
                roundEnded = false;
                currentSeat = 0;
            }
        }
        int start = currentSeat;

        do {
            SushiItem item = seats.get(currentSeat).poll();
            currentSeat = ++currentSeat % totalSeats;

            if (item != null) {
                return item;
            }
        } while (currentSeat != start);
        roundEnded = true;
        return null;
    }

    private void populateOrderAsPerSeat(ArrayList<SushiOrder> request) {
        for (SushiOrder order : request) {
            for (String roll : order.getMenuItemIds()) {
                seats.get(order.getSeatId() - 1).offer(
                        new SushiItem(order.getSeatId(), roll)
                );
            }
        }
    }

    private boolean hasAnyItemLeft(ArrayList<Queue<SushiItem>> seats) {
        for (int i = 0; i < seats.size(); i++) {
            if (!seats.get(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }
}