package plot.vehicle;

import plot.enums.VehicleType;
import plot.venue.ParkingTicket;

public abstract class Vehicle {
    private String licNumber;
    private final VehicleType type;
    private ParkingTicket parkingTicket;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public String getLicNumber() {
        return licNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.parkingTicket = ticket;
    }
}
