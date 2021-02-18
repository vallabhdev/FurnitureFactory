package designs.cloning;

import java.util.Arrays;

public class DeepCopy {
    private int[] data;

    public DeepCopy(int[] values) {
        data = new int[values.length];
        for (int each = 0; each < values.length; each++) {
            data[each] = values[each];
        }
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}
