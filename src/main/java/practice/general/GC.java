package practice.general;

public class GC {
    protected void finalize() {
        System.out.println("coding");
    }

    public static void main(String[] args) {
        GC gc = new GC();
        gc = null;
        System.gc();
    }
}
