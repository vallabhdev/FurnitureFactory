package practice;

public interface Second {
    void method();
    default void m27(){
        System.out.println("second");
    }
}
