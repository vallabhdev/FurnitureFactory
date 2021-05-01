package practice.general;

public class B {
    static {
        System.out.println("1");
    }

    B() {
        System.out.println("5");
    }

    {
        System.out.println("3");
    }

    {
        System.out.println("4");
    }

    static {
        System.out.println("2");
    }

    static {
        new B();
    }

    public static void main(String[] args) {
        // all static block first
        // all non-static code block second
        // all static block initing constructor
        System.out.println("in main method");
        new B();
        // all non-static code block second
    }
}
