package practice.general;

public class A {

    protected int x = 1;
    private String st = "number";

    private void innerInstance() {
        InnerA innerA = new InnerA();
        innerA.seeOut();
    }

    public static void main(String[] args) {
        A a = new A();
        a.innerInstance();
    }

    private class InnerA {
        private void seeOut() {
             int x = 2;
            System.out.println(st + " " + x);
        }
    }
}
