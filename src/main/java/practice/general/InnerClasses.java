package practice.general;

public class InnerClasses {
    private int age;
    String name;

    void defaultMethod() {
        System.out.println(age + name);
    }

    private void privateMethod() {
        new Into().privateMethod();
    }

    public static void main(String[] args) {
        InnerClasses innerClasses = new InnerClasses();
        innerClasses.privateMethod();
        innerClasses.defaultMethod();
    }

    private class Into {
//        private int age;
//        String name;

        void defaultMethod() {
            System.out.println(age + name);
        }

        void privateMethod() {
            age = 20;
            name = "twenty";
            defaultMethod();
        }
    }
}
