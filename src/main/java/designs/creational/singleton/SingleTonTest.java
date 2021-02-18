package designs.creational.singleton;

public class SingleTonTest {
    private static SingleTonTest innerInstance;

    static {
        innerInstance = new SingleTonTest();
    }

    private SingleTonTest() {
    }

    public static SingleTonTest getInstance() {
        return innerInstance;
    }

//    private static class SingleInner {
//        protected static final SingleTonTest innerInstance = new SingleTonTest();
//    }
}