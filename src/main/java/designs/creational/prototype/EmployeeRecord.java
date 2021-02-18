package designs.creational.prototype;

public class EmployeeRecord implements Prototype {
    private int id;
    private String name, designation;
    private double salary;
    private String address;

    public EmployeeRecord(int id, String name, String designation, double salary, String address) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.address = address;
    }

    public void showRecord() {
        System.out.println(id + "\t" + name + "\t" + designation + "\t" + salary + "\t" + address);
    }

    @Override
    public Prototype getClone() {
        return new EmployeeRecord(id, name, designation, salary, address);
    }
}
