package designs.creational.prototype;

public class Client {
    public static void main(String[] args) {
        EmployeeRecord e1 = new EmployeeRecord(1, "E1", "AVP", 20.0, "pune");
        EmployeeRecord e2 = (EmployeeRecord) e1.getClone();
        e1.showRecord();
        e2.showRecord();
        System.out.println(e1.equals(e2));
    }
}
