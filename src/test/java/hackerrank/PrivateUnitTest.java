package hackerrank;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PrivateUnitTest {
    private static FurnitureOrder furnitureFactory;

    @BeforeClass
    public static void instantiate() {
        furnitureFactory = new FurnitureOrder();
    }

    @Test
    public void _08_orderNothing() {
        furnitureFactory.addToOrder(Furniture.TABLE, 0);
        furnitureFactory.addToOrder(Furniture.CHAIR, 0);
        furnitureFactory.addToOrder(Furniture.COUCH, 0);

        assertEquals(0.0f, furnitureFactory.getTotalOrderCost());
    }

    @Test
    public void _09_placeOrders() {
        furnitureFactory.addToOrder(Furniture.TABLE, 6);
        furnitureFactory.addToOrder(Furniture.CHAIR, 10);
        furnitureFactory.addToOrder(Furniture.COUCH, 5);

        assertEquals(5000.0f, furnitureFactory.getTotalOrderCost());
    }

    @Test
    public void _10_validateFurnitureCostAndQuantity() {
//        ArrayList<Furniture> orderedFurniture = furnitureFactory.getOrderedFurniture();
        HashMap<Furniture, Integer> orderedFurniture = furnitureFactory.getOrderedFurniture();

        assertEquals(21, orderedFurniture.values().stream().mapToInt(Integer::intValue).sum());

        orderedFurniture.keySet().forEach(furniture -> {
            if ("Chair".equals(furniture.label())) {
                assertEquals(100.0f, furniture.cost());
            }

            if ("Table".equals(furniture.label())) {
                assertEquals(250.0f, furniture.cost());
            }

            if ("Couch".equals(furniture.label())) {
                assertEquals(500.0f, furniture.cost());
            }
        });

        assertEquals(10, furnitureFactory.getTypeCount(Furniture.CHAIR));
        assertEquals(1000.0f, furnitureFactory.getTypeCost(Furniture.CHAIR));

        assertEquals(6, furnitureFactory.getTypeCount(Furniture.TABLE));
        assertEquals(1500.0f, furnitureFactory.getTypeCost(Furniture.TABLE));

        assertEquals(5, furnitureFactory.getTypeCount(Furniture.COUCH));

        assertEquals(2500.0f, furnitureFactory.getTypeCost(Furniture.COUCH));

        // Validates order size
        assertEquals(21, furnitureFactory.getTotalOrderQuantity());
    }

    @Test
    public void _11_validateFurniture() {
    	for (Furniture f : Furniture.values()) {
    		switch(f.label()) {
    		case("Chair"):
    			assertEquals(100.0f, f.cost());
    			break;
    		case("Table"):
    			assertEquals(250.0f, f.cost());
    			break;
    		case("Couch"):
    			assertEquals(500.0f, f.cost());
    			break;
    		}
    	}
    }
}
