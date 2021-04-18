package practice.general;

public class B {
    static {
        System.out.println("2");
    }

    B() {
        System.out.println("c");
    }

    {
        System.out.println("0");
    }
    {
        System.out.println("AA");
    }

    static {
        System.out.println("1");
    }

    static {
        new B();
    }

    public static void main(String[] args) {

    }
}
