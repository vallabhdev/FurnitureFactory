package designs.cloning;

import java.util.HashMap;
import java.util.Map;

public class CloningClient {
    public static void main1(String[] args) {
        int[] val = {1, 2, 3, 4, 5};
        ShallowCopy shallowCopy = new ShallowCopy(val);
        shallowCopy.showData();
        val[0] = 11;
        shallowCopy.showData();

        DeepCopy deepCopy = new DeepCopy(val);
        deepCopy.showData();
        val[0] = 111;
        deepCopy.showData();
    }

    public static void main(String[] args) {
        Map<String, String> temp = new HashMap<>();
        temp.put("1", "one");
        Integer[] i = {1, 2, 3};
        ImmutableExample example = new ImmutableExample("Immutable", temp, i);
        System.out.println(example);
        temp.put("2", "two");
        System.out.println(example);
        example.getMap().put("3", "three");
        System.out.println(example);
    }
}
