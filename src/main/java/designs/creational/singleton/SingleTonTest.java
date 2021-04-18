package designs.creational.singleton;

public class SingleTonTest {
    private static SingleTonTest instance;
//    private static SingleTonTest innerInstance;

//    static {
//        innerInstance = new SingleTonTest();
//    }

    private SingleTonTest() {
    }

    public static SingleTonTest getInstance() {
        if (instance == null) {
            synchronized (SingleTonTest.class) {
                if (instance == null) {
                    instance = new SingleTonTest();
                }
            }
        }
        return instance;
    }

//    private static class SingleInner {
//        protected static final SingleTonTest innerInstance = new SingleTonTest();
//    }
}