package practice.exceptions;

public class NoClassDefErrExample {
    public static void main(String[] args) {
        try {
            new ClassWithInitError();//will throw ExceptionInInitializerError
        } catch (Throwable e) {
            System.out.println(e);
        }
//      will now throw NoClassDefFoundError as class not loaded previously, but initiated again.
        System.out.println(new ClassWithInitError());
    }

    public static class ClassWithInitError {
        static int data = 1 / 0;
    }
}
