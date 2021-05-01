package practice.general;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class Child1 extends Parent1 {
//    static method can be invoked using class reference (not object type)
//    access privileges can't be weaker in child class while overriding
//    overriding method in child class can't throw higher checkedException

    static void staticMethod(int i) {
        System.out.println("static child");
    }

    void m1(String i) throws AccessDeniedException {
        System.out.println("child1 m1 string");
    }

    public static void main(String[] args) throws IOException {
        Parent1 obj = new Child1();
        Child1 c = new Child1();
        obj.m1(null);
        obj.staticMethod(0);
        c.staticMethod(0);

        c.overloaded(0);
        c.overloaded(null);
    }

    private void overloaded(int i) {
        System.out.println("overloaded " + i);
    }

    private void overloaded(Integer i) {
        System.out.println("overloaded by wrapper " + i);
    }

    private void overloaded(Object i) {
        System.out.println("overloaded Object " + i);
    }
}
