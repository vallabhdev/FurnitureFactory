package hackerrank;

import java.util.HashMap;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private HashMap<Furniture, Integer> orderedFurniture;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        orderedFurniture = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        orderedFurniture.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return orderedFurniture;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float totalCost = 0.0f;
        for (Furniture each : orderedFurniture.keySet()) {
            int countForEachFurniture = orderedFurniture.get(each) != null ? orderedFurniture.get(each) : 0;
            totalCost = totalCost + countForEachFurniture * each.cost();
        }
        return totalCost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        for (Furniture furniture : orderedFurniture.keySet()) {
            if (furniture.equals(type)) {
                return orderedFurniture.get(furniture);
            }
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        Integer totalCountForType = orderedFurniture.get(type);
        return totalCountForType != null ? totalCountForType * type.cost() : 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int totalQuantity = 0;
        for (Furniture each : orderedFurniture.keySet()) {
            int countForEachFurniture = orderedFurniture.get(each) != null ? orderedFurniture.get(each) : 0;
            totalQuantity = totalQuantity + countForEachFurniture;
        }
        return totalQuantity;
    }
}