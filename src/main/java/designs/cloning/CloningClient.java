package designs.cloning;

public class CloningClient {
    public static void main(String[] args) {
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
}
