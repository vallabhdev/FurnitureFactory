package designs.creational.builder;

public class PersonBuilder {
    private String name;
    private int age;
    private String city;
    private String phone;

    public PersonBuilder withName(String value) {
        this.name = value;
        return this;
    }

    public PersonBuilder withAge(int value) {
        this.age = value;
        return this;
    }

    public PersonBuilder withCity(String value) {
        this.city = value;
        return this;
    }

    public PersonBuilder withPhone(String value) {
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
