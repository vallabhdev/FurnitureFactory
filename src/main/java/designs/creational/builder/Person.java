package designs.creational.builder;

public class Person {
    private String name;
    private int age;
    private String city;
    private String phone;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    static class PersonBuilder {

        private String name;
        private int age;
        private String city;
        private String phone;

        public PersonBuilder withName(String value) {
            name = value;
            return this;
        }

        public PersonBuilder withAge(int value) {
            age = value;
            return this;
        }

        public PersonBuilder withCity(String value) {
            city = value;
            return this;
        }

        public PersonBuilder withPhone(String value) {
            phone = value;
            return this;
        }

        public Person build() {
            Person person = new Person();
            if (name != null) {
                person.setName(name);
            }
            if (age >= 0) {
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
}
