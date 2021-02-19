package designs.structural.composite;

import java.util.Arrays;

public class CompositeClient {
    public static void main(String[] args) {
        Employee ceo = new Employee("E1", "CEO", 100);
        Employee headOfEng = new Employee("E2", "headOfEng", 90);
        Employee associate = new Employee("E3", "associate", 80);
        ceo.add(headOfEng);
        headOfEng.add(associate);
        for (Employee each : Arrays.asList(ceo, headOfEng, associate)) {
            System.out.println("Self = " + each);
            for (Employee subordinate : each.getSubordinates()) {
                System.out.println("My Subordinate is :" + subordinate);
            }
        }
    }
}
