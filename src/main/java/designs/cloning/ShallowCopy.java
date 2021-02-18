package designs.cloning;

import java.util.Arrays;

public class ShallowCopy {
    private int[] data;

    public ShallowCopy(int[] values) {
        data = values;
    }

    public void showData() {
        System.out.println(Arrays.toString(data));
    }
}
