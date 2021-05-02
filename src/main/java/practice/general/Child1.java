package practice.general;

import java.util.TreeSet;

public class Child1 extends Parent1 {
//    static method can be invoked using class reference (not object type)
//    access privileges can't be weaker in child class while overriding
//    overriding method in child class can't throw higher checkedException
//    While overriding, subclass method can't impose stricter method signature than parent one.
//    Static methods can not be overridden(Method Overriding vs Method Hiding)
//    Final & private methods can not be overridden
//    The overriding method must have same return type (or subtype called Covariant return type)
//    We can call parent class method in overriding method using super keyword.
//    Constructors can not be overriden bcz its name remains same as className & hence no chance to reuse in child class.
//    synchronized & strictfp keywords has no impact on overriding rules.

/*    Rule#1 : If the super-class overridden method does not throw an exception,
    subclass overriding method can only throws the unchecked exception,
    throwing checked exception will lead to compile-time error.

    Rule#2 : If the super-class overridden method does throws an exception,
    subclass overriding method can only throw same, subclass exception.
    Throwing parent exception in Exception hierarchy will lead to compile time error.
    Also there is no issue if subclass overridden method is not throwing any exception.*/

    static void staticMethod(int i) { // this will hide Parent1.staticMethod() while overriding
        System.out.println("static child");
    }

    synchronized strictfp TreeSet m1(String i) { // still this is an overridden method with Covariant type & no exception in signature.
        System.out.println("child1 m1 string");
        return null;
    }

    public static void main(String[] args) {
        Parent1 obj = new Child1();

        Child1 c = new Child1();
        obj.m1("Hi");
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
