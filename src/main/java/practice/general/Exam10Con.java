package practice.general;

public class Exam10Con {
    private String store;
    private Exam10 exam10;

    public Exam10Con(String name, int age, String store) {
        this.exam10 = new Exam10(name, age);
        this.store = store;
    }

    public static void main(String[] args) {
        Exam10Con obj = new Exam10Con("Name", 20, "store");
        Exam10 obj1 = new Exam10("Name", 20);
        System.out.println(obj.equals(obj1));
        System.out.println(obj1.equals(obj));
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Exam10Con))
            return false;
        Exam10Con other = (Exam10Con) o;
        boolean exam10Equals = (this.exam10 == null && other.exam10 == null)
                || (this.exam10 != null && this.exam10.equals(other.exam10));
        boolean storeEquals = (this.store == null && other.store == null)
                || (this.store != null && this.store.equals(other.store));
        return exam10Equals && storeEquals;
    }
}
