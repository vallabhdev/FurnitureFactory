package designs.creational.abstractfactory.factories;

public class FactoryCreator {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Bank")) {
            return new BankFactory();
        } else if (choice.equalsIgnoreCase("loan")) {
            return new LoanFactory();
        }
        return null;
    }
}
