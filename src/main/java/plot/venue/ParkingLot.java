package plot.venue;

import plot.enums.VehicleType;
import plot.vehicle.Vehicle;

import java.util.Map;

public class ParkingLot {
    private String name;
    private String address;
    private ParkingRate parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private final int maxHandicapCount;
    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxElectricCount;

    //    private Map<String, ParkingFloor> parkingFloors;
//    private Map<String, ParkingFloor> parkingFloors;
    private Map<String, ParkingFloor> parkingFloors;
    private Map<String, ParkingTicket> parkingTickets;

    private static ParkingLot parkingLot;

    private ParkingLot() {
        this.name = "Gojek Parking Space";
        this.address = "Gojek Parking Bengaluru";
        this.maxHandicapCount = 10;
        this.maxCompactCount = 100;
        this.maxLargeCount = 100;
        this.maxMotorbikeCount = 200;
        this.maxElectricCount = 100;
    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
        if (isFull(vehicle.getType())) {
            throw new ParkingFullException();
        }
        ParkingTicket ticket = new ParkingTicket();
        vehicle.assignTicket(ticket);
        //save ticket
        incrementSpotCount(vehicle.getType());
        return ticket;
    }

    private boolean isFull(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }
        if (type == VehicleType.MOTORBIKE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }
        if (type == VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    private void incrementSpotCount(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType.MOTORBIKE) {
            motorbikeSpotCount++;
        } else if (type == VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }

    public boolean isFull() {
        for (String key : parkingFloors.keySet()) {
            if (!parkingFloors.get(key).isFull()) {
                return false;
            }
        }
        return true;
    }

    public void addParkingFloor(ParkingFloor floor) {

    }
}