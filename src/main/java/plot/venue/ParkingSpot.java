package plot.venue;

import plot.enums.ParkingSpotType;
import plot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String number;

    private boolean free;
    private Vehicle vehicle;
    private ParkingSpotType type;
    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public boolean isFree() {
        return free;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
        return true;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        free = true;
        return true;
    }
}
