package practice;

public interface First {
    void method();

    default void m1(){
        System.out.println("first");
    }
    default void m2(){
        System.out.println("first");
    }default void m3(){
        System.out.println("first");
    }
}
