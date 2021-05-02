package practice.general;

import practice.exceptions.MyUncheckedException;

import java.util.Set;

public class Parent1 {
//    static methods can be overloaded.
//    overloading can't be achieved by just changing return type
//    main method can also be overloaded.

    static void staticMethod(int i) {
        System.out.println("static parent");
    }

    Set m1(String i) throws MyUncheckedException {
        System.out.println("parent1 m1 string");
        return null;
    }

    void m1(Object i) {
        System.out.println("parent1 m1 int");
    }

    public void show(int a) {
        System.out.println("in int " + a);
    }

    public void show(String a) {
        System.out.println("in String " + a);
    }

    public void show(byte a) {
        System.out.println("in byte " + a);
    }

    public void show(double a) {
        System.out.println("in long " + a);
    }

    public static void main(String[] args) {
        Parent1 p = new Parent1();
        p.show('a');
        p.show(1l);
        p.show(0);
        p.show(1.0f);
        p.main("hi");
    }

    public static void main(String args) {
        System.out.println(args + " overridden by main");
    }
}
