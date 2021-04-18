package designs.creational.builder;

public class Client {
    public static void main1(String[] args) {
        Person prateek = new PersonBuilder().withAge(22).withName("prateek").build();
        Person soni = new PersonBuilder().withAge(20).withName("soni").withPhone("1233").build();
        System.out.println(prateek.toString());
        System.out.println(soni.toString());
    }

    public static void main(String[] args) {
        Person prateek = new Person.PersonBuilder().withAge(22).withName("prateek").build();
        Person soni = new PersonBuilder().withAge(20).withName("soni").withPhone("1233").build();
        System.out.println(prateek.toString());
        System.out.println(soni.toString());
    }
}
