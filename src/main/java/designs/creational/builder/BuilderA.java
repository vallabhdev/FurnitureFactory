package designs.creational.builder;

public class BuilderA {
    private String name;
    private int age;
    private String city;
    private String phone;

    public BuilderA withName(String value) {
        this.name = value;
        return this;
    }

    public BuilderA withAge(int value) {
        this.age = value;
        return this;
    }

    public BuilderA withCity(String value) {
        this.city = value;
        return this;
    }

    public BuilderA withPhone(String value) {
        this.phone = value;
        return this;
    }

    public Person build() {
        Person person = new Person();
        if (name != null) {
            person.setName(name);
        }
        if (age != 0) {
            person.setAge(age);
        }
        if (city != null) {
            person.setCity(city);
        }
        if (phone != null) {
            person.setPhone(phone);
        }
        return person;
    }
}
