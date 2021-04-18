package practice.general;

import java.util.ArrayList;
import java.util.List;

public final class ImmutableExample {
    private final String name;
    private final int age;
    private final List<String> addresses;

    public ImmutableExample(String name, int age, List<String> addresses) {
        this.name = name;
        this.age = age;
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getAddresses() {
        return new ArrayList<>(addresses);
    }

    @Override
    public String toString() {
        return "ImmutableExample{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addresses=" + addresses +
                '}';
    }
}
