package plot.venue;

import plot.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    private String name;
    private Map<String, HandicappedSpot> handicappedSpots = new HashMap<>();
    private Map<String, CompactSpot> compactSpots = new HashMap<>();
    private Map<String, LargeSpot> largeSpots = new HashMap<>();
    private Map<String, MotorbikeSpot> motorbikeSpots = new HashMap<>();
    private Map<String, ElectricSpot> electricSpots = new HashMap<>();

    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot) {
        switch (spot.getType()) {
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), (HandicappedSpot) spot);
                break;
            case COMPACT:
                compactSpots.put(spot.getNumber(), (CompactSpot) spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), (LargeSpot) spot);
                break;
            case MOTORBIKE:
                motorbikeSpots.put(spot.getNumber(), (MotorbikeSpot) spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), (ElectricSpot) spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
    }

    public void releaseSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.removeVehicle(vehicle);
        switch (spot.getType()) {
            case HANDICAPPED:
                handicappedSpots.remove(spot.getNumber());
                break;
            case LARGE:
                largeSpots.remove(spot.getNumber());
                break;
            case COMPACT:
                compactSpots.remove(spot.getNumber());
                break;
            case ELECTRIC:
                electricSpots.remove(spot.getNumber());
                break;
            case MOTORBIKE:
                motorbikeSpots.remove(spot.getNumber());
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public boolean isFull() {
        return false;
    }
}
