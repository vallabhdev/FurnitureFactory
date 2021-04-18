package practice.general;

public class Exam10 {
    protected String name;
    protected int age;

    public Exam10(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Exam10)) {
            return false;
        }
        Exam10 other = (Exam10) o;
        return (this.age == other.age) && (this.name == null && other.name == null)
                || (this.name != null && this.name.equals(other.name));
    }
}
