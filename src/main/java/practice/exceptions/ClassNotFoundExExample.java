package practice.exceptions;

public class ClassNotFoundExExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> name = Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println(name);
        //Oracle driver dependency is not added. so class will not be found in classpath.
    }
}
