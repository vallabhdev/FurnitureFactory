package designs.creational.singleton;


public class Client {
    public static void main(String[] args) {
        SingleTonTest i1 = SingleTonTest.getInstance();
        SingleTonTest i2 = SingleTonTest.getInstance();
        System.out.println(i1.equals(i2));
    }
}
