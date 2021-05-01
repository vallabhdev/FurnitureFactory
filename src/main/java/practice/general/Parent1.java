package practice.general;

import java.io.IOException;

public class Parent1 {

    static void staticMethod(int i) {
        System.out.println("static parent");
    }

    void m1(String i) throws IOException {
        System.out.println("parent1 m1 string");
    }

    void m1(Object i) {
        System.out.println("parent1 m1 int");
    }
}
